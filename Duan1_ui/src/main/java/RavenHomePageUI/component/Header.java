package RavenHomePageUI.component;

import CodeMain.Config.HibernateUtil;
import RavenLogin.login.Login;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import org.hibernate.Session;

public class Header extends javax.swing.JPanel {

    private Session s;
    private Login l;

    public Header() {
        initComponents();
        setOpaque(false);
        s = HibernateUtil.getFactory().openSession();
        l = new Login();
        if (l.ndLogin != null) {
            txtChucVu.setText(l.ndLogin.isChucVu() ? "Quản lí" : "Nhân viên");
            txtten.setText(l.ndLogin.getHoTen());
            btn_avt.setIcon(new ImageIcon("src/main/icon/"+l.ndLogin.getImage()));            
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setPaint(new GradientPaint(0, 0, Color.decode("#00c6ff"), width, 0, Color.decode("#0072ff")));
        g2.fillRect(0, 0, width, height);
        g2.dispose();
        super.paintComponent(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new RavenHomePageUI.swing.Button();
        btn_avt = new RavenHomePageUI.swing.Button();
        txtChucVu = new javax.swing.JLabel();
        txtten = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setIcon(new ImageIcon("src/main/icon/fpt60.png"));
        button1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        btn_avt.setForeground(new java.awt.Color(255, 255, 255));
        btn_avt.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        btn_avt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Demo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_avt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_avt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_avtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_avtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private RavenHomePageUI.swing.Button btn_avt;
    private RavenHomePageUI.swing.Button button1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel txtChucVu;
    private javax.swing.JLabel txtten;
    // End of variables declaration//GEN-END:variables
}
