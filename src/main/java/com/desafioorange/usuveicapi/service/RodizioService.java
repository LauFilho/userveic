package com.desafioorange.usuveicapi.service;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Locale;

public class RodizioService {

	public static String diaRodizio(Integer ano) {
		int dia = regraRodizio(ano);
		// permite lidar de forma individual com elementos que compoem uma data
		DateFormatSymbols simbolo = new DateFormatSymbols(new Locale("pt", "BR"));
		String[] nomesDosDias = simbolo.getWeekdays();
		return nomesDosDias[dia];
		
	}	
	// item 2 do desafio do rodizio
	 public static boolean isDiaRodizio(Integer ano) {
	        Calendar hoje = Calendar.getInstance(new Locale("pt", "BR"));
	        return hoje.get(Calendar.DAY_OF_WEEK) == regraRodizio(ano);
	    }

	private static int regraRodizio(Integer ano) {
		// Pegar apenas o último dígito
		String valorFinalAno = ano.toString().substring(3);

		if (valorFinalAno.equals("0") || valorFinalAno.equals("1"))
			return Calendar.MONDAY;
		if (valorFinalAno.equals("2") || valorFinalAno.equals("3"))
			return Calendar.TUESDAY;
		if (valorFinalAno.equals("4") || valorFinalAno.equals("5"))
			return Calendar.WEDNESDAY;
		if (valorFinalAno.equals("6") || valorFinalAno.equals("7"))
			return Calendar.THURSDAY;
		if (valorFinalAno.equals("8") || valorFinalAno.equals("9"))
			return Calendar.FRIDAY;
		return 0;
	}
	
	

}
