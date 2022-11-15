package RavenLogin.login2;

import RavenLogin.login2.PanelCustom;


public class Forgetpass extends PanelCustom {

   
    public Forgetpass() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtnam = new RavenLogin.swing2.TextField();
        textField2 = new RavenLogin.swing2.TextField();
        textField3 = new RavenLogin.swing2.TextField();
        password1 = new RavenLogin.swing2.Password();
        btnForgetPass = new RavenLogin.swing2.Button();

        setBackground(new java.awt.Color(58, 58, 58));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(242, 242, 242));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Forget Pass");

        txtnam.setForeground(new java.awt.Color(242, 242, 242));
        txtnam.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        txtnam.setHint("NAME");

        textField2.setForeground(new java.awt.Color(242, 242, 242));
        textField2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        textField2.setHint("EMAIL");

        textField3.setForeground(new java.awt.Color(242, 242, 242));
        textField3.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        textField3.setHint("USER NAME");

        password1.setForeground(new java.awt.Color(242, 242, 242));
        password1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        password1.setHint("PASSWORD");

        btnForgetPass.setBackground(new java.awt.Color(86, 142, 255));
        btnForgetPass.setForeground(new java.awt.Color(255, 255, 255));
        btnForgetPass.setText("Forget pass");
        btnForgetPass.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnForgetPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(password1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtnam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(textField2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(password1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnForgetPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RavenLogin.swing2.Button btnForgetPass;
    private javax.swing.JLabel jLabel1;
    private RavenLogin.swing2.Password password1;
    private RavenLogin.swing2.TextField textField2;
    private RavenLogin.swing2.TextField textField3;
    private RavenLogin.swing2.TextField txtnam;
    // End of variables declaration//GEN-END:variables
}
