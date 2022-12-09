package quizzy;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class MenuFrame extends JFrame{
    private Question question;
    private JTextArea quiz;
    public void setUpMenu(){
        Quiz q = null;
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        JMenu mnuQuiz = new JMenu ("Quiz");
        mbar.add(mnuFile);
        mbar.add(mnuQuiz);
        JMenuItem miStart = new JMenuItem("Start");
        miStart.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    q.quizQs(true);
                    
                    repaint();
                }     
            }
        );
        JMenuItem miStop = new JMenuItem("Stop");
        miStop.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    double x = q.quizQs(false);
                    JOptionPane.showMessageDialog(null, "You got a score ");

                } 
            }
        );
        JMenuItem miload = new JMenuItem("Load File");
        miload.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    JFileChooser chooser = new JFileChooser();
                    File f;
                    if(chooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION){
                        f = chooser.getSelectedFile();
                        if(QuestionReader.readFromText(f)){
                            quiz.setText("The Questions have been read. Select Quiz>>Start to begin");
                            repaint();
                        }else {
                            JOptionPane.showMessageDialog(null, "Could not load the questions from file");
                        }
                    }
                }
            }
        );
        mnuFile.add(miload);
        mnuQuiz.add(miStart);
        mnuQuiz.add(miStop);
        
    }   
    public void setupGUI(){
        setTitle("Object Oriented Quiz Tool");
        setBounds(100,100,600,400);
        setUpMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        quiz = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\n "
        + "Select File >> Load Questions to begin.");
        quiz.setEditable(false);
        c.add(quiz,BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        JLabel lblEnter = new JLabel("Your Answer");
        JTextField txtEnter = new JTextField(5);
        JButton btnSubmit = new JButton("Submit Answer");
        btnSubmit.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    String ans = txtEnter.getText();
                    
                }
            }
        );
        JButton btnNextQues = new JButton("Next Question");
        panSouth.add(lblEnter);
        panSouth.add(txtEnter);
        panSouth.add(btnSubmit);
        panSouth.add(btnNextQues);
        c.add(panSouth,BorderLayout.SOUTH);
    }
    public MenuFrame(Question question){
        this.question = question;
        setupGUI();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
