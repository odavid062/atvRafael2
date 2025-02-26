package org.example;

import org.example.Service.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication  // Marca esta classe como a aplicação Spring Boot
public class Main {

    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot e obtém o contexto da aplicação
        ApplicationContext context = SpringApplication.run(Main.class, args);
        BookingService bookingService = context.getBean(BookingService.class);

        Scanner scanner = new Scanner(System.in); // Scanner para entrada do usuário
        int option;
        do {
            // Exibe o menu de opções
            System.out.println("1 - Fazer reserva");
            System.out.println("2 - Listar reservas");
            System.out.println("3 - Cancelar reserva");
            System.out.println("4 - Criar sala");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            option = scanner.nextInt(); // Captura a opção do usuário
            scanner.nextLine(); // Consumir a quebra de linha

            switch (option) {
                case 1:
                    // Captura os dados da reserva
                    System.out.print("Digite seu nome: ");
                    String user = scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String room = scanner.nextLine();
                    bookingService.makeReservation(room, user); // Chama o serviço para fazer a reserva
                    break;
                case 2:
                    bookingService.listReservations(); // Chama o serviço para listar reservas
                    break;
                case 3:
                    // Captura os dados para cancelar a reserva
                    System.out.print("Digite seu nome: ");
                    String cancelUser = scanner.nextLine();
                    System.out.print("Digite o nome da sala: ");
                    String cancelRoom = scanner.nextLine();
                    bookingService.cancelReservation(cancelRoom, cancelUser); // Cancela a reserva
                    break;
                case 4:
                    // Criar uma nova sala
                    System.out.print("Digite o nome da nova sala: ");
                    String roomName = scanner.nextLine();
                    bookingService.createRoom(roomName); // Chama o serviço para criar uma sala
                    break;
                case 0:
                    System.out.println("Encerrando..."); // Mensagem de saída
                    break;
                default:
                    System.out.println("Opção inválida."); // Validação de opção inválida
            }
        } while (option != 0); // Repete até o usuário escolher sair (0)

        scanner.close(); // Fecha o scanner
    }
}
