package transaction.view.menu;

import javax.swing.JOptionPane;
import transaction.model.config.GlobalConfigJdbc;
import transaction.model.config.GlobalConfigJdbcImplement;
import transaction.model.item.ItemJdbc;
import transaction.model.item.ItemJdbcImplement;
import transaction.view.item.FormItem;
import transaction.view.report.FormReport;
import transaction.view.supplier.FormSupplier;
import transaction.view.transaction.FormBuy;

public class FormMenu extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private static GlobalConfigJdbc globalConfigJdbc;
    private static ItemJdbc itemJdbc;

    public FormMenu() {
        initComponents();
        globalConfigJdbc = new GlobalConfigJdbcImplement();
        itemJdbc = new ItemJdbcImplement();

        jLabelHeader.setText(globalConfigJdbc.selectGlobalConfigValue(1L));
        jLabelFooter.setText(globalConfigJdbc.selectGlobalConfigValue(2L));
    }

    private void doSupplier() {
        jDesktopPane1.removeAll();
        jDesktopPane1.updateUI();
        FormSupplier formSupplier = new FormSupplier();
        jDesktopPane1.add(formSupplier);
        formSupplier.setVisible(true);
    }

    private void doItem() {
        jDesktopPane1.removeAll();
        jDesktopPane1.updateUI();
        FormItem formItem = new FormItem();
        jDesktopPane1.add(formItem);
        formItem.setVisible(true);
    }

    private void doBuy() {
        if (itemJdbc.countTotal()) {
            jDesktopPane1.removeAll();
            jDesktopPane1.updateUI();
            FormBuy formBuy = new FormBuy();
            jDesktopPane1.add(formBuy);
            formBuy.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Barang belum di isi", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void doReport() {
        jDesktopPane1.removeAll();
        jDesktopPane1.updateUI();
        FormReport formReport = new FormReport();
        jDesktopPane1.add(formReport);
        formReport.setVisible(true);
    }

    private void doLogout() {
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar ? ", "Warning", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            jDesktopPane1.removeAll();
            jDesktopPane1.updateUI();
            this.setVisible(false);
            FormLogin formLogin = new FormLogin();
            formLogin.setVisible(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelHeader = new javax.swing.JLabel();
        jPanelButton = new javax.swing.JPanel();
        jButtonSupplier = new javax.swing.JButton();
        jButtonItem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonBuy = new javax.swing.JButton();
        jButtonReport = new javax.swing.JButton();
        jButtonLogout = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanelFooter = new javax.swing.JPanel();
        jLabelFooter = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 51, 51));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 400));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.PAGE_AXIS));

        jPanelHeader.setBackground(new java.awt.Color(255, 255, 0));
        jPanelHeader.setLayout(new java.awt.GridLayout(1, 0));

        jLabelHeader.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelHeader.setForeground(new java.awt.Color(0, 0, 255));
        jLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeader.setText("HEADER");
        jPanelHeader.add(jLabelHeader);

        jPanel1.add(jPanelHeader);

        jPanelButton.setBackground(new java.awt.Color(0, 0, 0));
        jPanelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelButton.setLayout(new java.awt.GridLayout(1, 0));

        jButtonSupplier.setText("Supplier");
        jButtonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSupplierActionPerformed(evt);
            }
        });
        jPanelButton.add(jButtonSupplier);

        jButtonItem.setText("Barang");
        jButtonItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonItemActionPerformed(evt);
            }
        });
        jPanelButton.add(jButtonItem);

        jPanel1.add(jPanelButton);

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        jButtonBuy.setText("Pembelian");
        jButtonBuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuyActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonBuy);

        jButtonReport.setText("Laporan");
        jButtonReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonReportActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonReport);

        jButtonLogout.setText("Keluar");
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLogout);

        jPanel1.add(jPanel2);

        jDesktopPane1.setBackground(new java.awt.Color(255, 255, 255));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(956, 400));
        jDesktopPane1.setLayout(new javax.swing.BoxLayout(jDesktopPane1, javax.swing.BoxLayout.LINE_AXIS));
        jPanel1.add(jDesktopPane1);

        jPanelFooter.setBackground(new java.awt.Color(255, 255, 0));
        jPanelFooter.setLayout(new java.awt.GridLayout(1, 0));

        jLabelFooter.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelFooter.setForeground(new java.awt.Color(0, 0, 255));
        jLabelFooter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFooter.setText("FOOTER");
        jPanelFooter.add(jLabelFooter);

        jPanel1.add(jPanelFooter);

        getContentPane().add(jPanel1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSupplierActionPerformed
        doSupplier();
    }//GEN-LAST:event_jButtonSupplierActionPerformed

    private void jButtonItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonItemActionPerformed
        doItem();
    }//GEN-LAST:event_jButtonItemActionPerformed

    private void jButtonBuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuyActionPerformed
        doBuy();
    }//GEN-LAST:event_jButtonBuyActionPerformed

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        doLogout();
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jButtonReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonReportActionPerformed
        doReport();
    }//GEN-LAST:event_jButtonReportActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new FormMenu().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuy;
    private javax.swing.JButton jButtonItem;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonReport;
    private javax.swing.JButton jButtonSupplier;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFooter;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    // End of variables declaration//GEN-END:variables

}
