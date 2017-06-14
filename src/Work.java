/* Work.java 
*/
/* Work <- Record �N���X���p�� 
*/
public class Work extends Record {
    /** 
    * �t�B�[���h 
    */
    private int personID; // �]�ƈ�ID 
    private int clientID; // �ڋqID 
    private String startTime; // �ғ��J�n�N���� 

    private String endTime; // �ғ��I���N���� 
    private int price; // �_��P�� 

    /** �R���X�g���N�^ Work 
    * @param int ID 
    * @param int personID 
    * @param int clientID 
    * @param String startTime 
    * @param String endTime 
    * @param int price 
    * @param boolean eraseFlag 
    */
    Work(int ID, int personID, int clientID,
            String startTime, String endTime,
            int price, boolean eraseFlag) {
        super(ID, eraseFlag);
        this.personID = personID;
        this.clientID = clientID;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
    }

    /** �R���X�g���N�^ Work 
    * @param String record 
    * @throws Exception 
    */
    Work(String record) throws Exception {
        setData(record);
    }

    /** setData 
    * @param String record 
    * @throws Exception 
    */
    public void setData(String record) throws Exception {
        String[] n = record.split(","); // ���R�[�h��","�ŕ��� 
        try {
            if (n.length != 7)
                throw new ArrayIndexOutOfBoundsException("�s���ȃ��R�[�h��ǂݍ��݂܂����B");
            setID(Integer.parseInt(n[0]));
            personID = Integer.parseInt(n[1]);
            clientID = Integer.parseInt(n[2]);
            startTime = n[3];
            endTime = n[4];
            price = Integer.parseInt(n[5]);
            if (n[6].equals("t"))
                setEraseFlag(true);
            else if (n[6].equals("f"))
                setEraseFlag(false);
            else
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println
                    ("���l�܂��͍폜�t���O�ɕϊ��ł��Ȃ��l�����R�[�h�Ɋ܂܂�Ă��܂��B");
            throw e;
        }
    }

    /** toString 
    * @return String 
    
    */
    public String toString() {
        String ts = "ID:" + getID() + " �]�ƈ�ID:" + personID
                + " �ڋqID:" + clientID
                + " " + startTime + "�`" + endTime
                + " �_��P��:" + price;
        return ts;
    }

    // ���ۃ��\�b�hwriteForCSV �̎��� 
    /** writeForCSV 
    * @return String 
    */
    public String writeForCSV() {
        String s = "" + getID() + "," + personID + "," + clientID +
                "," + startTime + "," + endTime +
                "," + price + "," + (getEraseFlag() ? "t" : "f");
        return s;
    }

    /** getPersonID 
    * @return int 
    */
    public int getPersonID() {
        return personID;
    }

    /** setPersonID 
    * @param int personID 
    */
    public void setPersonID(int personID) {
        this.personID = personID;
    }

    /** getClientID 
    * @return int 
    */
    public int getClientID() {
        return clientID;
    }

    /** setClientID 
    * @param int clientID 
    */
    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    /** getStartTime 
    * @return String 
    */
    public String getStartTime() {
        return startTime;
    }

    /** setStartTime 
    * @param String startTime 
    */
    public void setStartTime(String startTime) {
        this.startTime = startTime;

    }

    /** getEndTime 
    * @return String 
    */
    public String getEndTime() {
        return endTime;
    }

    /** setEndTime 
    * @param String endTime 
    */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /** setPrice 
    * @param int price 
    */
    public void setPrice(int price) {
        this.price = price;
    }
}