package user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.X509EncodedKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

import bbs.Bbs;

public class UserDAO {
	// dao : �����ͺ��̽� ���� ��ü�� ���ڷμ�
	// ���������� db���� ȸ������ �ҷ����ų� db�� ȸ������ ������
	private Connection conn; // connection:db�������ϰ� ���ִ� ��ü
	private PreparedStatement pstmt;
	private ResultSet rs;

	// mysql�� ������ �ִ� �κ�
	public UserDAO() { // ������ ����ɶ����� �ڵ����� db������ �̷�� �� �� �ֵ�����
		try {
//			String dbURL = "jdbc:mysql://localhost:3306/recipe?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//			String dbID = "root";
//			String dbPassword = "1234";
//			Class.forName("com.mysql.jdbc.Driver");
			String dbURL = "jdbc:oracle:thin:@localhost:1521:XE";
			String dbID = "a201645006";
			String dbPassword = "manager";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {
			e.printStackTrace(); // ������ �������� ���
		}
	}
	
	//user�� �����ϴ� �Լ�
	public User getUser(String userEmail) {
		String SQL = "SELECT * FROM userDB WHERE userEmail = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setUserEmail(rs.getString("userEmail"));
				user.setUserName(rs.getString("userName"));
				user.setUserDate(rs.getString("userDate"));
				user.setAdminCheck(rs.getInt("adminCheck"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// �α����� �õ��ϴ� �Լ�****
	public int Login(String userEmail, String userPassword) {
		String SQL = "SELECT * FROM userdb WHERE userEmail = ?";
		String hashpassword = null;
		String pwindb = null;

		//password �ؽð����� ��ȯ
		String saltstr = "salt"; // salt
		byte[] salt = saltstr.getBytes(); // byteȭ
		byte[] a = userPassword.getBytes();
		byte[] bytes = new byte[a.length + salt.length]; // salt�� password�� ��ħ

		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		try {

			try {
				MessageDigest md = MessageDigest.getInstance("SHA-256"); //sha-256�� �ؽ��Լ��� ���
				md.update(bytes);

				byte[] byteData = md.digest();

				StringBuffer sb = new StringBuffer();	//�ؽð��� ������ ����
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
				}
				hashpassword = sb.toString(); //hashpassword�� String���� ����
				System.out.println(hashpassword);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			pstmt = conn.prepareStatement(SQL);
			// pstmt : prepared statement ������ sql������ db�� �����ϴ� �������� �ν��Ͻ�������
			// sql������ ���� ��ŷ����� ����ϴ°�... pstmt�� �̿��� �ϳ��� ������ �̸� �غ��ؼ�(����ǥ���)
			// ����ǥ�ش��ϴ� ������ �������̵��, �Ű������� �̿�.. 1)�����ϴ��� 2)��й�ȣ��������
			pstmt.setString(1, userEmail);
			//rs:result set �� �������
			rs = pstmt.executeQuery();
			//������� �����Ѵٸ� while�� ����
			while (rs.next()) {
				int admincheck = rs.getInt("ADMINCHECK");	//���������� Ȯ��
				System.out.println(admincheck);
				pwindb = rs.getString("userPassword");	
				System.out.println(pwindb);//DB�� ����� �н����� ������
				if (admincheck == 3) {						//�����ڶ��(�����ڴ� ���� �� ��ȭ�� ������ ���� ��ĪŰ�� ��ȣȭ)
					//������ǻ�Ϳ� ����� ��ȣŰ �ҷ�����
					BufferedReader brKey = new BufferedReader(
							new FileReader("C:/Workspace/Project/smarteditorSample/WebContent/DESKey.txt"));
					String sKey = brKey.readLine();
					// ��ȣŰ ���ڵ�
					byte[] bKey = Base64.decodeBase64(sKey.getBytes()); //��� ������ ���·� ��ȯ
					X509EncodedKeySpec SecretKey = new X509EncodedKeySpec(bKey);
					SecretKeySpec keySpec = new SecretKeySpec(SecretKey.getEncoded(), "DES");
					Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); //DES�� �̿��Ͽ� ��,��ȣȭ �غ�
					cipher.init(Cipher.DECRYPT_MODE, keySpec);	//��ȣȭ �غ�
					byte[] cleartext = cipher.doFinal(Base64.decodeBase64(pwindb));	//��ȣȭ�� �����Ͽ� �� ����
					pwindb = new String(Base64.encodeBase64(cleartext)); //pwindb�� ��ȣȭ�� pw�� ����.
				}
				if (hashpassword.equals(pwindb)) { //�Էµ� pwssword�� �ؽð��� db�� ����� pw ���Ͽ� ������
					return 1; // ��� ����
				} else {		//�ٸ� ��
					return 0; // ��й�ȣ ����ġ
				}
			}
			return -1; // ���̵� ���� ����
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; //�����ͺ��̽� ���� �߻�

	}

	public int join(User user) {
		String SQL = "INSERT INTO USERDB(userEmail, userPassword, userName, userDate) VALUES (?,?,?,?)";
		String saltstr = "salt"; // salt
		byte[] salt = saltstr.getBytes(); // byteȭ
		byte[] a = user.getUserPassword().getBytes();
		byte[] bytes = new byte[a.length + salt.length]; // salt�� password�� ��ħ

		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); //sha-256�� �ؽ��Լ��� ���
			md.update(bytes);

			byte[] byteData = md.digest();

			StringBuffer sb = new StringBuffer();	//�ؽð��� ������ ����
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
			String hashpassword = sb.toString(); //hashpassword�� String���� ����
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, hashpassword);
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserDate());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // DB ����
	}
	
	public int Adminjoin(User user) {
		String SQL = "INSERT INTO USERDB(userEmail, userPassword, userName, userDate, adminCheck) VALUES (?,?,?,?,3)";
		String saltstr = "salt"; // salt
		byte[] salt = saltstr.getBytes(); // byteȭ
		byte[] a = user.getUserPassword().getBytes();
		byte[] bytes = new byte[a.length + salt.length]; // salt�� password�� ��ħ

		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256"); //sha-256�� �ؽ��Լ��� ���
			md.update(bytes);

			byte[] byteData = md.digest();

			StringBuffer sb = new StringBuffer();	//�ؽð��� ������ ����
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}
			String hashpassword = sb.toString(); //hashpassword�� String���� ����
			BufferedReader brKey = new BufferedReader(
					new FileReader("C:/Workspace/Project/smarteditorSample/WebContent/DESKey.txt"));
			String sKey = brKey.readLine();
			// ��ȣŰ ���ڵ�
			byte[] bKey = Base64.decodeBase64(sKey.getBytes()); //��� ������ ���·� ��ȯ
			X509EncodedKeySpec SecretKey = new X509EncodedKeySpec(bKey);
			SecretKeySpec keySpec = new SecretKeySpec(SecretKey.getEncoded(), "DES");
			Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); //DES�� �̿��Ͽ� ��,��ȣȭ �غ�
			cipher.init(Cipher.ENCRYPT_MODE, keySpec);	//��ȣȭ �غ�
			byte[] ciphertext = cipher.doFinal(Base64.decodeBase64(hashpassword));	//��ȣȭ�� �����Ͽ� ��ȣ�� ����
			String cipherpw = new String(Base64.encodeBase64(ciphertext)); //cipherpw�� ��ȣȭ�� pw�� ����.
			
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getUserEmail());
			pstmt.setString(2, cipherpw);
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getUserDate());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1; // DB ����
	}
}