/* Record.java 
*/
/* Record 
*/
abstract public class Record {
    /** 
    * �t�B�[���h 
    */
    private int ID;
    private boolean eraseFlag;

    /** 
    * �R���X�g���N�^ Record 
    */
    Record() {
        this.ID = -1;
        this.eraseFlag = false;
    }

    /** �R���X�g���N�^ Record 
    * @param int ID 
    * @param boolean eraseFlag 
    */
    Record(int ID, boolean eraseFlag) {
        this.ID = ID;
        this.eraseFlag = eraseFlag;

    }

    /** getID 
    * @return int 
    */
    public int getID() {
        return ID;
    }

    /** setID 
    * @param int ID 
    */
    public void setID(int ID) {
        this.ID = ID;
    }

    /** getEraseFlag 
    * @return boolean 
    */
    public boolean getEraseFlag() {
        return eraseFlag;
    }

    /** setEraseFlag 
    * @param boolean eraseFlag 
    */
    public void setEraseFlag(boolean eraseFlag) {
        this.eraseFlag = eraseFlag;
    }

    // ���ۃ��\�b�h 
    /** writeForCSV 
    * �������e�FCSV �t�@�C���ɏo�͂���l��Ԃ� 
    * @return String 
    */
    public abstract String writeForCSV();
}