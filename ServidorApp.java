import java.io.*;
import java.net.*;
import java.net.Socket;


public class ServidorApp
{
	private static int _porta = 9090;
	static String msg_cliente;
	static ServerSocket srvApp;
	static Socket sk = new Socket();
	
	public static void criarThread() throws InterruptedException
	{
		
    ServerSocket servidor = new ServerSocket(9090);
	
	while(true)
		{
			           
		Socket socket = servidor.accept();

		System.out.println("Nova conexao estabelecida. \nCriando nova thread de comunicacao...");
                    
		Thread cliente = new Thread(new TCPServerThread(sk, msg_cliente));
		cliente.start();
						
		}
	
	}
	
	private static void aguardarConexao() throws Exception
	{
		ServidorApp.srvApp = new ServerSocket(_porta);
		System.out.println("\nA Porta " +_porta+ " foi ABERTA! \nAguardando nova conexao..." );
		InetAddress inet = InetAddress.getByName("localhost");
		
		while(true)
		{
			ServidorApp.sk = srvApp.accept();
			System.out.println("Informacao coletada do cliente...");
			System.out.println(inet.getHostAddress());
			System.out.println(inet.getHostName());
			
			BufferedReader recebercliente = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			
			ServidorApp.msg_cliente = recebercliente.readLine();
			System.out.println("Mensagem Recebida do Cliente: " +msg_cliente);
			
			
			
		}
	}
	public static void main(String[]args) throws Exception
	{
		
		ServidorApp.aguardarConexao();
		ServidorApp.criarThread();
	}
	
}