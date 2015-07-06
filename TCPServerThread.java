import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;


public class TCPServerThread implements Runnable
{
	private Socket _socket;
	private String _msg;
	
	static TCPServerThread tcp;
	
	public TCPServerThread(Socket socket, String msg)
	{
		this._socket = socket;
		this._msg    = msg;
	
	
		try
		{
			File file = new File("c:\\temp\\Msg"+Thread.currentThread().getId()+".txt");
            FileWriter w = new FileWriter(file);
            w.write("Mensagem do ServidorApp" +_msg);
            w.close();
			System.out.println("Arquivo" +file+ "criado... ");
			
		}
		catch (IOException ex)
		{
			
		}
	}
    @Override
	public void run()
	{

	}
}