package br.com.servertcp.entities;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Aplication {

	public static void main(String args[]) {

		try {

			while (true) {
				// Instanciando a classe principal ServerSocket, e passando para o construtor
				// dela o numero da porto do servidor.
				ServerSocket server = new ServerSocket(6643);

				// Imprimindo a porta que o servidor esta escutando.
				System.out.println("Servidor iniciado na porta 6643");

				// O metodo accept() esculta se ha alguma conexao com servidor e a aceita.
				// enquanto o metodo accept() não é execultado, todo o codigo abaixo dele tb
				// nãocé excultado.
				Socket cliente = server.accept();

				// O metodo getInetAddress() -> captura o endereço IP no qual o socket esta
				// conectado.
				// O metodo getHostAddress() -> pega o IP capturado pelo metodo getInetAddress()
				// e o converte para string no formato de IP.
				System.out.println("Cliente conectado do IP " + cliente.getInetAddress().getHostAddress());

				// Classe Scanner instanciada com o metodo getInputStream(), capitura o que foi
				// digitado pelo cliente.
				Scanner entrada = new Scanner(cliente.getInputStream());
				String reportStt[] = entrada.next().split(";");

				System.out.println("Cabeçalho: " + reportStt[0] + "\n");
				System.out.println("ID: " + reportStt[1] + "\n");
				System.out.println("Versão: " + reportStt[2] + "\n");
				System.out.println("Data: " + reportStt[3] + "\n");
				System.out.println("Horario: " + reportStt[4] + "\n");
				System.out.println("CellID: " + reportStt[5] + "\n");
				System.out.println("Lat: " + reportStt[6] + "\n");
				System.out.println("Long: " + reportStt[7] + "\n");
				System.out.println("Velocidade: " + reportStt[8] + "\n");
				System.out.println("Curso: " + reportStt[9] + "\n");
				System.out.println("Numero de satelite: " + reportStt[10] + "\n");
				System.out.println("FIX: " + reportStt[11] + "\n");
				System.out.println("Odometro: " + reportStt[12] + "\n");
				System.out.println("Bateria Principal: " + reportStt[13] + "\n");
				System.out.println("IO: " + reportStt[14] + "\n");
				System.out.println("Mode: " + reportStt[15] + "\n");
				System.out.println("Mensagem: " + reportStt[16] + "\n");
				System.out.println("Horimetro: " + reportStt[17] + "\n");
				System.out.println("Bateria Backup: " + reportStt[18] + "\n");
				System.out.println("Memory: " + reportStt[19] + "\n");
				System.out.println("RPM: " + reportStt[20] + "\n");
				System.out.println("Ibuttom: " + reportStt[21] + "\n");
				System.out.println("Drive_ID: " + reportStt[22] + "\n");

				// O metodo hasNextLine() retorna true sempre que tiver uma quebra de linha no
				// final da string.
				// while (entrada.hasNextLine()) {

				// Impressao do que esta sendo escrito pelo cliente no console.
				// System.out.println(entrada.nextLine());

				// }

				// Finalisando a leitura do que esta vindo pelo socket.
				entrada.close();

				// Finalizando o a conexao socket.
				server.close();
			}

		} catch (IOException ex) {

			// Tratando as Excecoes.
			Logger.getLogger(Aplication.class.getName()).log(Level.SEVERE, null, ex);
		}

	}
}