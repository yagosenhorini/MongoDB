package br.com.sistema.medico;

import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;

import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import java.util.Arrays;

import java.util.Scanner;

public class Sistema {
	
	public static void main(String [] args){
		
		Scanner sc = new Scanner(System.in);
		String nome;
		String fone;
		
		try{
			//Criando conexão com o Servidor do Banco//
			MongoClient conecta = new MongoClient("localhost", 27017);
			
			//Criando conexão com a base de dados//
			DB database = conecta.getDB("sistema");
			
			System.out.println("Conexão OK");
			
			//Conexão com a Collection//
			DBCollection paciente = database.getCollection("paciente");
			
			
				
				//Criando o objeto JSON//
				BasicDBObject query = new BasicDBObject();
				System.out.println("Informe o nome: ");
				query.put("nome", sc.nextLine());
				System.out.println("Informe o telefone: ");
				query.put("fone", sc.nextLine());
				
				paciente.insert(query);
			
			
			DBCursor cursor = paciente.find();
			while(cursor.hasNext()){
				BasicDBObject pac = (BasicDBObject) cursor.next();
				System.out.println(pac.getString("nome"));
			}
			
		}catch (Exception ex){
			System.out.println("Erro: " +ex.getMessage());
				
				
			}
			
		}
		
		
	}


