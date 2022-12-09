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
        //sets up menu
        Quiz q = null;
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        JMenu mnuQuiz = new JMenu ("Quiz");
        mbar.add(mnuFile);
        mbar.add(mnuQuiz);
        //"should" start quiz when clicked
        JMenuItem miStart = new JMenuItem("Start");
        miStart.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String ques = q.quizQ(true);
                    quiz.setText(ques);
                    repaint();
                }     
            }
        );
        //"should" stop the quiz and return user a score
        JMenuItem miStop = new JMenuItem("Stop");
        miStop.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    String x = q.quizQ(false);
                    JOptionPane.showMessageDialog(null, "You got a score ");

                } 
            }
        );
        //loads file from file window pane
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
        //title of the window
        setTitle("Object Oriented Quiz Tool");
        setBounds(100,100,600,400);
        setUpMenu();
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        //prints welcome message
        quiz = new JTextArea("Welcome to Quizzy, the object-oriented programming quiz tool.\n "
        + "Select File >> Load Questions to begin.");
        quiz.setEditable(false);
        c.add(quiz,BorderLayout.CENTER);
        JPanel panSouth = new JPanel();
        panSouth.setLayout(new FlowLayout());
        //formated bottom of window with two buttons and a text feild
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
