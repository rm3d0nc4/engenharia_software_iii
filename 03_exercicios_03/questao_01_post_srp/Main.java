package questao_01_post_srp;

import java.io.*;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        RepositorioDePosts repositorioDePosts = new RepositorioDePosts();

        Autor autor1 = new Autor(1, "anastacio", "anastacio@email.com");
        Autor autor2 = new Autor(2, "zuila", "zuila@email.com");

        Post post1 = new Post(1, "qualquer coisa", autor1, new Date());
//
        File currentDirectory = new File(".");
        String canonicalPath = currentDirectory.getCanonicalPath();
        repositorioDePosts.saveToFile(post1, canonicalPath + "/files/post1.txt");
        System.out.println("Post salvo!");
//
        Post postRecuperado = repositorioDePosts.loadFromFile(canonicalPath + "/files/post1.txt");
        System.out.println("Post recuperado:");
        System.out.println(postRecuperado.toString());
    }
}

class Autor {
    private int id;
    private String nome;
    private String email;
    public Autor(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public int getId() {return this.id;}
    public String getNome() {return this.nome;}
    public String getEmail() {return this.email;}

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

class Post {
    private int id;
    private String texto;
    private Autor autor;
    private Date data;
    private int quantidadeDeLikes;
    public Post(int id, String texto, Autor autor, Date data) {
        this.id = id;
        this.texto = texto;
        this.autor = autor;
        this.data = new Date(data.getTime());
        this.quantidadeDeLikes = 0;
    }

    public Post() {}
    public int getId() {
        return id;
    }
    public String getTexto() { return texto; }
    public Autor getAutor() {
        return autor;
    }
    public Date getData() {
        return new Date(data.getTime());
    }
    public int getQuantidadeDeLikes() {
        return quantidadeDeLikes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setQuantidadeDeLikes(int quantidadeDeLikes) {
        this.quantidadeDeLikes = quantidadeDeLikes;
    }


    @Override
    public String toString() {
        String format = String.format("Post( id: %d, texto: %s, autor: %s, data: %s )", this.id, this.texto, this.autor.getNome(), this.data.toString());
        return format;
    }
}

class RepositorioDePosts {

    public RepositorioDePosts() {}
    public void saveToFile(Post post, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("ID: " + post.getId() + "\n");
            writer.write("Texto: " + post.getTexto() + "\n");
            writer.write("Autor: " + post.getAutor().getNome() + "\n");
            writer.write("Data: " + post.getData().getTime() + "\n");
            writer.write("Quantidade de Likes: " + post.getQuantidadeDeLikes() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Post loadFromFile(String filePath) {
        Post post = new Post();
        try (FileReader reader = new FileReader(filePath)) {
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(":");
                String key = parts[0].trim();
                String value = parts[1].trim();

                switch (key) {
                    case "ID":
                        post.setId(Integer.parseInt(value));
                        break;
                    case "Texto":
                        post.setTexto(value);
                        break;
                    case "Autor":

                        post.setAutor(new Autor(1, value, "email@mail.com"));
                        break;
                    case "Data":
                        Date date = Date.from(Instant.ofEpochMilli(Long.parseLong(value)));
                        post.setData(date);
                        break;
                    case "Quantidade de Likes":
                        post.setQuantidadeDeLikes(Integer.parseInt(value));
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return post;
    }
}
