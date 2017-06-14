/* ExitStatus.java 
*/
/* ExitStatus 
*/
public class ExitStatus extends ConsoleStatus {
    /* �R���X�g���N�^ ExitStatus 
    * @param String firstMess 
    * @param String promptMess 
    * @param boolean IsEndStatus 
    */
    ExitStatus(String firstMess, String promptMess, boolean IsEndStatus) {
        super(firstMess, promptMess, IsEndStatus);
    }

    // �V�X�e�����I��������ʂȃ��b�Z�[�W 
    /** 
    * displayFirstMess 
    */
    public void displayFirstMess() {
        System.out.println("�V�X�e�����I�����܂��B");
    }
}