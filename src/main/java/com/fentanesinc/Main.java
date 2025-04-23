package com.fentanesinc;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.fentanesinc.Model.ResponseSearchMovieDTO;
import com.fentanesinc.Services.TmdbServices;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
		System.out.println("Digite o nome do filme que deseja pesquisar:");
		String name = scan.next();
        scan.close();
        
        ResponseSearchMovieDTO responseSearchMovieTO = TmdbServices.getInstance().serachMovieByName(name);

        for (ResponseSearchMovieDTO.Result result : responseSearchMovieTO.results) {
            System.out.println("#####################################");
            System.out.println(result.title);
            System.out.println(result.release_date);
            System.out.println(result.adult);
        }
    }
}