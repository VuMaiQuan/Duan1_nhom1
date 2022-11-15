package RavenLogin.login2;

import CodeMain.Utilities.HibernateUtil;
import CodeMain.domainModel.NguoiDung;
import CodeMain.domainModel.TaiKhoan;
import CodeMain.repository.TaiKhoanRepository;
import RavenLogin.swing2.EventLogin;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Login extends PanelCustom {

    private EventLogin event;
    private TaiKhoanRepository tkrepo;
    private List<TaiKhoan> list_tk = new ArrayList<>();

    public Login() {
        initComponents();
        tkrepo = new TaiKhoanRepository();
        list_tk = tkrepo.getList();

    }

    public void setEventLogin(EventLogin event) {
        this.event = event;
    }

    public boolean checkValidate() {
        if (txtUserName.getText().trim().length() == 0) {
            return false;
        }
        if (txtPassWord.getText().trim().length() == 0) {
            return false;
        }
        return true;
    }
    public static NguoiDung ndLogin = null;

    public NguoiDung checkLogin(String user, String pass) {
        NguoiDung nd = null;
        for (TaiKhoan x : list_tk) {
            if (user.equals(x.getUserName()) && pass.equals(x.getPassword())) {
                nd = x.getNguoiDung();
                return nd;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUserName = new RavenLogin.swing2.TextField();
        txtPassWord = new RavenLogin.swing2.Password();
        btnSignIn = new RavenLogin.swing2.Button();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(247, 247, 247));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(76, 76, 76));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN IN");

        txtUserName.setForeground(new java.awt.Color(76, 76, 76));
        txtUserName.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtUserName.setHint("USER NAME");

        txtPassWord.setForeground(new java.awt.Color(76, 76, 76));
        txtPassWord.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtPassWord.setHint("PASSWORD");

        btnSignIn.setBackground(new java.awt.Color(86, 142, 255));
        btnSignIn.setForeground(new java.awt.Color(255, 255, 255));
        btnSignIn.setText("Sign In");
        btnSignIn.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(76, 76, 76));
        jLabel2.setText("Or Sign in with");

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Duan1\\RunCode\\Duan1_ui\\src\\main\\java\\RavenLogin\\icon\\facebook.png")); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton2.setIcon(new javax.swing.ImageIcon("D:\\Duan1\\RunCode\\Duan1_ui\\src\\main\\java\\RavenLogin\\icon\\google-plus.png")); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jButton3.setIcon(new javax.swing.ImageIcon("D:\\Duan1\\RunCode\\Duan1_ui\\src\\main\\java\\RavenLogin\\icon\\twitter.png")); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPassWord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPassWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1))
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed

        if (checkValidate()) {
            ndLogin = checkLogin(txtUserName.getText(), txtPassWord.getText());
            if (ndLogin != null) {
                event.loginDone();
            } else {
                JOptionPane.showMessageDialog(this, "Sai tài khoản mk");
            }
        } else {
            JOptionPane.showMessageDialog(this, "không được để trống");
        }

//        if (getAlpha() == 0) {
//            event.loginDone();
//        }
    }//GEN-LAST:event_btnSignInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RavenLogin.swing2.Button btnSignIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private RavenLogin.swing2.Password txtPassWord;
    private RavenLogin.swing2.TextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
