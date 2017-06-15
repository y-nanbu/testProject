/* FileLoader.java
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
/* FileLoader
*/
public class FileLoader {
/**
* フィールド
*/
private String fileName;
/** コンストラクタ FileLoader
* @param String fileName
*/
FileLoader( String fileName ) {
this.fileName = fileName;
}
/** read
* @param RecordList rl
* @throws Exception
*/
public void read( RecordList rl ) throws Exception {
// ファイル名＝fileName のファイルを読む
BufferedReader input = null;
try {
try {
input = new BufferedReader( new FileReader( fileName ) );
String s;
while( (s = input.readLine()) != null )
rl.add( s );
} finally {
if (input != null)
input.close();
}
} catch( FileNotFoundException e ) {
System.out.println( fileName + "を開くことができません。" );
throw e;
} catch( IOException e ) {
System.out.println( "ファイル読込み中にエラーが発生しました。" );
throw e;
}
}
}