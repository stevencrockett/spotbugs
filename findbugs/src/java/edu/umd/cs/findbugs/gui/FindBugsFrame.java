/*
 * FindBugsFrame.java
 *
 * Created on March 30, 2003, 12:05 PM
 */

package edu.umd.cs.findbugs.gui;

import java.awt.CardLayout;
import java.awt.Component;
import java.io.File;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;

/**
 * This frame contains all of the controls used by the FindBugs GUI.
 * I suppose this code should be modularized some more, maybe turning some of
 * component into Bean classes.  However, this is my first Swing program,
 * so I'm taking the most straightforward approach I can.
 *
 * @author David Hovemeyer
 */
public class FindBugsFrame extends javax.swing.JFrame {
    
    /**
     * Custom cell renderer for the navigator tree.
     */
    private static class MyCellRenderer extends DefaultTreeCellRenderer {
        private ImageIcon rootIcon;
        private ImageIcon projectIcon;

        public MyCellRenderer() {
            ClassLoader classLoader = this.getClass().getClassLoader();
            rootIcon = new ImageIcon(classLoader.getResource("edu/umd/cs/findbugs/gui/bug2.png"));
            projectIcon = new ImageIcon(classLoader.getResource("edu/umd/cs/findbugs/gui/gear.png"));
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel,
             boolean expanded, boolean leaf, int row, boolean hasFocus) {

            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

            // Set the icon, depending on what kind of node it is
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
            Object obj = node.getUserObject();
            if (obj instanceof ProjectCollection) {
                setIcon(rootIcon);
            } else if (obj instanceof Project) {
                setIcon(projectIcon);
            }

            return this;
        }
    }
    
    /** Filename used for new projects. */
    private static final String UNTITLED_PROJECT = "<<untitled project>>";
    
    /** Creates new form FindBugsFrame */
    public FindBugsFrame() {
	initComponents();
        postInitComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        navigatorTree = new javax.swing.JTree();
        viewPanel = new javax.swing.JPanel();
        emptyPanel = new javax.swing.JPanel();
        bugTree = new javax.swing.JTree();
        reportPanel = new javax.swing.JPanel();
        editProjectPanel = new javax.swing.JPanel();
        jarFileLabel = new javax.swing.JLabel();
        jarNameTextField = new javax.swing.JTextField();
        addJarButton = new javax.swing.JButton();
        jarFileListLabel = new javax.swing.JLabel();
        sourceDirLabel = new javax.swing.JLabel();
        srcDirTextField = new javax.swing.JTextField();
        addSourceDirButton = new javax.swing.JButton();
        sourceDirListLabel = new javax.swing.JLabel();
        removeJarButton = new javax.swing.JButton();
        removeSrcDirButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        browseJarButton = new javax.swing.JButton();
        browseSrcDirButton = new javax.swing.JButton();
        editProjectLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        findBugsButton = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jarFileList = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        sourceDirList = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newProjectItem = new javax.swing.JMenuItem();
        openProjectItem = new javax.swing.JMenuItem();
        closeProjectItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        exitItem = new javax.swing.JMenuItem();

        setTitle("FindBugs");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        jSplitPane1.setResizeWeight(0.4);
        navigatorTree.setModel(createNavigatorTreeModel());
        jScrollPane1.setViewportView(navigatorTree);

        jSplitPane1.setLeftComponent(jScrollPane1);

        viewPanel.setLayout(new java.awt.CardLayout());

        viewPanel.add(emptyPanel, "EmptyPanel");

        viewPanel.add(bugTree, "BugTree");

        viewPanel.add(reportPanel, "ReportPanel");

        editProjectPanel.setLayout(new java.awt.GridBagLayout());

        jarFileLabel.setText("Jar file:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        editProjectPanel.add(jarFileLabel, gridBagConstraints);

        jarNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jarNameTextFieldActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        gridBagConstraints.weightx = 1.0;
        editProjectPanel.add(jarNameTextField, gridBagConstraints);

        addJarButton.setText("Add");
        addJarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJarButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        editProjectPanel.add(addJarButton, gridBagConstraints);

        jarFileListLabel.setText("Jar Files:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        editProjectPanel.add(jarFileListLabel, gridBagConstraints);

        sourceDirLabel.setText("Source Dir:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        editProjectPanel.add(sourceDirLabel, gridBagConstraints);

        srcDirTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcDirTextFieldActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 0);
        gridBagConstraints.weightx = 1.0;
        editProjectPanel.add(srcDirTextField, gridBagConstraints);

        addSourceDirButton.setText("Add");
        addSourceDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSourceDirButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        editProjectPanel.add(addSourceDirButton, gridBagConstraints);

        sourceDirListLabel.setText("Source Dirs:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        editProjectPanel.add(sourceDirListLabel, gridBagConstraints);

        removeJarButton.setText("Remove");
        removeJarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJarButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        editProjectPanel.add(removeJarButton, gridBagConstraints);

        removeSrcDirButton.setText("Remove");
        removeSrcDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSrcDirButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        editProjectPanel.add(removeSrcDirButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        editProjectPanel.add(jSeparator1, gridBagConstraints);

        browseJarButton.setText("...");
        browseJarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseJarButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        editProjectPanel.add(browseJarButton, gridBagConstraints);

        browseSrcDirButton.setText("...");
        browseSrcDirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSrcDirButtonActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        editProjectPanel.add(browseSrcDirButton, gridBagConstraints);

        editProjectLabel.setBackground(new java.awt.Color(0, 0, 204));
        editProjectLabel.setFont(new java.awt.Font("Dialog", 1, 24));
        editProjectLabel.setForeground(new java.awt.Color(255, 255, 255));
        editProjectLabel.setText("Project");
        editProjectLabel.setOpaque(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        editProjectPanel.add(editProjectLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        editProjectPanel.add(jSeparator2, gridBagConstraints);

        findBugsButton.setText("Find Bugs!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        editProjectPanel.add(findBugsButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        editProjectPanel.add(jSeparator4, gridBagConstraints);

        jScrollPane2.setPreferredSize(new java.awt.Dimension(259, 1));
        jarFileList.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jarFileList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jarFileList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.weighty = 0.7;
        editProjectPanel.add(jScrollPane2, gridBagConstraints);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(259, 1));
        sourceDirList.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.LOWERED));
        sourceDirList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(sourceDirList);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 3, 0, 3);
        gridBagConstraints.weighty = 0.3;
        editProjectPanel.add(jScrollPane3, gridBagConstraints);

        viewPanel.add(editProjectPanel, "EditProjectPanel");

        jSplitPane1.setRightComponent(viewPanel);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        fileMenu.setText("File");
        newProjectItem.setText("New Project");
        newProjectItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectItemActionPerformed(evt);
            }
        });

        fileMenu.add(newProjectItem);

        openProjectItem.setText("Open Project");
        fileMenu.add(openProjectItem);

        closeProjectItem.setText("Close Project");
        fileMenu.add(closeProjectItem);

        fileMenu.add(jSeparator3);

        exitItem.setText("Exit");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });

        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }//GEN-END:initComponents

    private void browseSrcDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSrcDirButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int rc = chooser.showDialog(this, "Add source directory");
        if (rc == JFileChooser.APPROVE_OPTION)
            srcDirTextField.setText(chooser.getSelectedFile().getPath());
    }//GEN-LAST:event_browseSrcDirButtonActionPerformed

    private void srcDirTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcDirTextFieldActionPerformed
        addSourceDirToList();
    }//GEN-LAST:event_srcDirTextFieldActionPerformed

    private void jarNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jarNameTextFieldActionPerformed
        addJarToList();
    }//GEN-LAST:event_jarNameTextFieldActionPerformed

    private void browseJarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseJarButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) { return file.isDirectory() || file.getName().endsWith(".jar"); }
            public String getDescription() { return "Jar files (*.jar)"; }
        };
        chooser.setFileFilter(filter);
        int rc = chooser.showDialog(this, "Add Jar file");
        if (rc == JFileChooser.APPROVE_OPTION)
            jarNameTextField.setText(chooser.getSelectedFile().getPath());
    }//GEN-LAST:event_browseJarButtonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
	navigatorTree.setSelectionPath(new TreePath(rootNode));
    }//GEN-LAST:event_formWindowOpened

    private void newProjectItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectItemActionPerformed
        Project project = new Project(UNTITLED_PROJECT);
        projectCollection.addProject(project);
        DefaultMutableTreeNode projectNode = new DefaultMutableTreeNode(project);
        rootNode.add(projectNode);
        navigatorTree.setSelectionPath(new TreePath(new Object[]{rootNode, projectNode}));
    }//GEN-LAST:event_newProjectItemActionPerformed
    
    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        exitFindBugs();
    }//GEN-LAST:event_exitItemActionPerformed

    private void removeSrcDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSrcDirButtonActionPerformed
	// if (sourceDirList.hasCurrentSelect()) {
	//   Project project = getCurrentProject();
	//   String currSelection = sourceDirList.getCurrentSelection();
	//   project.removeSourceDirectory(currSelection);
	//   sourceDirList.removeCurrentSelection();
	// }
    }//GEN-LAST:event_removeSrcDirButtonActionPerformed

    private void removeJarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJarButtonActionPerformed
	// if (jarList.hasCurrentSelection()) {
	//   Project project = getCurrentProject();
	//   String currSelection = jarList.getCurrentSelection();
	//   project.removeJarFile(currSelection);
	//   jarList.removeCurrentSelection();
	// }
    }//GEN-LAST:event_removeJarButtonActionPerformed

    private void addSourceDirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSourceDirButtonActionPerformed
        addSourceDirToList();
    }//GEN-LAST:event_addSourceDirButtonActionPerformed

    private void addJarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJarButtonActionPerformed
        addJarToList();
    }//GEN-LAST:event_addJarButtonActionPerformed
    
    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
	exitFindBugs();
    }//GEN-LAST:event_exitForm
    
    /**
     * Create the tree model that will be used by the navigator tree.
     */
    private TreeModel createNavigatorTreeModel() {
        projectCollection = new ProjectCollection();
        rootNode = new DefaultMutableTreeNode(projectCollection);
        navigatorTreeModel = new DefaultTreeModel(rootNode);
        return navigatorTreeModel;
    }

    /**
     * This is called from the constructor to perform post-initialization
     * of the components in the form.
     */
    private void postInitComponents() {
        viewPanelLayout = (CardLayout) viewPanel.getLayout();
        navigatorTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        navigatorTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                navigatorTreeSelectionChanged(e);
            }
        });

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        
        navigatorTree.setCellRenderer(new FindBugsFrame.MyCellRenderer());
	
	jarFileList.setModel(new DefaultListModel());
	sourceDirList.setModel(new DefaultListModel());
    }
    
    /**
     * This handler is called whenever the selection in the navigator
     * tree changes.
     * @param e the TreeSelectionEvent
     */
    private void navigatorTreeSelectionChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) navigatorTree.getLastSelectedPathComponent();

        if (node == null)
            return;

        Object nodeInfo = node.getUserObject();
        if (nodeInfo instanceof ProjectCollection) {
            // Project collection node - there is no view associated with this node
            setView("EmptyPanel");
        } else if (nodeInfo instanceof Project) {
            synchProject((Project) nodeInfo);
            setView("EditProjectPanel");
        }
    }
  
    /**
     * Get the currently selected project.
     * @return the current project, or null if no project is selected
     *   (which should only be possible if the root node is selected)
     */
    private Project getCurrentProject() {
	TreePath selPath = navigatorTree.getSelectionPath();
	// Work backwards from end until we get to a project.
	Object[] nodeList = selPath.getPath();
	for (int i = nodeList.length - 1; i >= 0; --i) {
	    DefaultMutableTreeNode node = (DefaultMutableTreeNode) nodeList[i];
	    Object nodeInfo = node.getUserObject();
	    if (nodeInfo instanceof Project)
		return (Project) nodeInfo;
	}
	return null;
    }
    
    /**
     * Synchronize the edit project dialog with given project.
     * @param project the selected project
     */
    private void synchProject(Project project) {
	// Clear text fields
	jarNameTextField.setText("");
	srcDirTextField.setText("");

	// Populate jar and source dir lists
	DefaultListModel jarListModel = (DefaultListModel) jarFileList.getModel();
	jarListModel.clear();
	for (int i = 0; i < project.getNumJarFiles(); ++i) {
	    jarListModel.addElement(project.getJarFile(i));
	}
	
	DefaultListModel srcDirListModel = (DefaultListModel) sourceDirList.getModel();
	srcDirListModel.clear();
	for (int i = 0; i < project.getNumSourceDirs(); ++i) {
	    srcDirListModel.addElement(project.getSourceDir(i));
	}
    }
    
    public void exitFindBugs() {
        // TODO: offer to save work, etc.
        System.exit(0);
    }
    
    /**
     * Set the view panel to display the named view.
     */
    public void setView(String viewName) {
        viewPanelLayout.show(viewPanel, viewName);
    }
    
    /**
     * Called to add the jar file in the jarNameTextField to the
     * Jar file list (and the project it represents).
     */
    private void addJarToList() {
	String jarFile = jarNameTextField.getText();
	if (!jarFile.equals("")) {
	    Project project = getCurrentProject();
	    project.addJar(jarFile);
	    DefaultListModel listModel = (DefaultListModel)  jarFileList.getModel();
	    listModel.addElement(jarFile);
	    jarNameTextField.setText("");
	}
    }
    
    /**
     * Called to add the source directory in the sourceDirTextField
     * to the source directory list (and the project it represents).
     */
    private void addSourceDirToList() {
        String sourceDir = srcDirTextField.getText();
        if (!sourceDir.equals("")) {
            Project project = getCurrentProject();
            project.addSourceDir(sourceDir);
            DefaultListModel listModel = (DefaultListModel) sourceDirList.getModel();
            listModel.addElement(sourceDir);
            srcDirTextField.setText("");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
	FindBugsFrame frame = new FindBugsFrame();
        frame.setView("EditProjectPanel");
        frame.setSize(750, 550);
        frame.show();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel editProjectLabel;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton removeSrcDirButton;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem closeProjectItem;
    private javax.swing.JMenuItem newProjectItem;
    private javax.swing.JTextField jarNameTextField;
    private javax.swing.JButton browseJarButton;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JMenuItem openProjectItem;
    private javax.swing.JList jarFileList;
    private javax.swing.JLabel jarFileLabel;
    private javax.swing.JButton addSourceDirButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton findBugsButton;
    private javax.swing.JLabel sourceDirLabel;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JButton removeJarButton;
    private javax.swing.JLabel jarFileListLabel;
    private javax.swing.JButton addJarButton;
    private javax.swing.JList sourceDirList;
    private javax.swing.JTree navigatorTree;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JPanel editProjectPanel;
    private javax.swing.JButton browseSrcDirButton;
    private javax.swing.JTextField srcDirTextField;
    private javax.swing.JLabel sourceDirListLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JPanel emptyPanel;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTree bugTree;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
    
    // My variable declarations
    private CardLayout viewPanelLayout;
    private ProjectCollection projectCollection;
    private DefaultTreeModel navigatorTreeModel;
    private DefaultMutableTreeNode rootNode;
}
