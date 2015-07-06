import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;


public class TCPClient
{
	public static void main(String []args) throws Exception
	{
		System.out.println("\nInciando cliente...\n");
        
        System.out.println("Inciando conexao com o servidor...\n");
        
        Socket socket = new Socket("localhost", 9090);
        
        System.out.println("Conexao Estabelecida...\n");
        
        InputStream input = socket.getInputStream();
        OutputStream output = socket.getOutputStream();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        PrintStream out = new PrintStream(output);
        
        Scanner scanner = new Scanner(System.in);
        
        while(true){
            System.out.print("Digite uma mesnagem: ");
            String mensagem = scanner.nextLine();   
            
            out.println(mensagem);
            
            if("FIM".equals(mensagem)){
                break;
            }
            mensagem = in.readLine();
            
            System.out.println(
                "Mensagem recebida do servidor: " + mensagem);
        }
        
        System.out.println("Encerrando conexao...");
        
        in.close();
        out.close();
        socket.close();
	}
}