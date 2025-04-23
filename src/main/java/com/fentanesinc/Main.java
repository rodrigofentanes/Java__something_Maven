package com.fentanesinc;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.fentanesinc.Model.ResponseSearchMovieDTO;
import com.fentanesinc.Services.TmdbServices;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome do filme que deseja pesquisar:");
		String name = scan.next();
        scan.close();
        
        ResponseSearchMovieDTO responseSearchMovieTO = TmdbServices.getInstance().serachMovieByName(name);

        String jsonResult = new GsonBuilder().setPrettyPrinting().create().toJson(responseSearchMovieTO);

        FileWriter file = new FileWriter("Result.json");
        file.write(jsonResult);
        file.close();

        for (ResponseSearchMovieDTO.Result result : responseSearchMovieTO.results) {
            System.out.println("#####################################");
            System.out.println(result.title);
            System.out.println(result.release_date);
            System.out.println(result.adult);
        }
    }
}