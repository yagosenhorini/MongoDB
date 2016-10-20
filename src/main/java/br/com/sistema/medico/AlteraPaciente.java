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

public class AlteraPaciente {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String nome;
		String fone;
		
		MongoClient paciente = new MongoClient("localhost", 27017);
		DB database = paciente.getDB("sistema");
		DBCollection pacientes = database.getCollection("paciente");
		
			
		BasicDBObject novo = new BasicDBObject();
		System.out.println("Entre com o novo nome: ");
		novo.put("&set", new BasicDBObject().append("nome", sc.nextLine()));
		
		System.out.println("Entre com o novo telefone: ");
		novo.put("&set", new BasicDBObject().append("fone", sc.nextLine()));
		
		System.out.println("Dados alterados!");
		
		paciente.close();
		sc.close();
		
		
		

	}

}
