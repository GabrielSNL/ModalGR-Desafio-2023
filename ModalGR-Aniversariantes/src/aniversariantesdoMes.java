import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class aniversariantesdoMes {
    public static void main(String[] args) {
        try {
            // Ler o arquivo existente na pasta do caminho selecionado (no caso fiz um de exemplo) que contém os dados dos consultores.
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Gabriel/IdeaProjects/ModalGR-Aniversariantes/dados_consultores.txt"));
            List<String> aniversariantes = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String linha;
            Date dataAtual = new Date();

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split("\\|");
                if (campos.length == 3) {
                    String nome = campos[0];
                    String email = campos[1];
                    Date dataNascimento = dateFormat.parse(campos[2]);

                    // Verificar se o consultor faz aniversário no mês corrente
                    if (dataNascimento.getMonth() == dataAtual.getMonth()) {
                        aniversariantes.add(nome + " | " + email + " | " + dateFormat.format(dataNascimento));
                    }
                }
            }

            reader.close();

            // Criar um novo arquivo com os aniversariantes do mês corrente
            BufferedWriter writer = new BufferedWriter(new FileWriter("aniversariantes_do_mes.txt"));
            for (String aniversariante : aniversariantes) {
                writer.write(aniversariante);
                writer.newLine();
            }
            writer.close();

            System.out.println("Arquivo 'aniversariantes_do_mes.txt' gerado com sucesso.");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
