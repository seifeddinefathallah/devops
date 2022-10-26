package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.Reglement;
import com.esprit.examen.entities.Stock;





@RunWith(SpringRunner.class)
@SpringBootTest
public class FactureServiceImplTest {
	@Autowired
	IFactureService FactureService;
	
	@Test
	public void testAddFacture() throws ParseException {
	
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("30/09/2000");
		Date dateDerniereModificationFacture = dateFormat.parse("31/10/2000");
		Facture F = new Facture(null, 20,1000,dateCreationFacture,dateDerniereModificationFacture, null, null, null, null);
		Facture facture = FactureService.addFacture(F);
		System.out.print("facture "+facture);
		assertNotNull(facture.getIdFacture());
			
	} 
	@Test
	public void testcancelFacture() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("30/09/2000");
		Date dateDerniereModificationFacture = dateFormat.parse("31/10/2000");
		Facture F = new Facture(null, 20,1000,dateCreationFacture,dateDerniereModificationFacture, null, null, null, null);
		Facture facture= FactureService.addFacture(F);
		FactureService.cancelFacture(facture.getIdFacture());
		assertNull(FactureService.retrieveFacture(facture.getIdFacture()));
	}
	
	@Test
	public void testretrieveAllFactures() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreationFacture = dateFormat.parse("30/09/2021");
		Date dateDerniereModificationFacture = dateFormat.parse("31/10/2022");
		List<Facture> cp = FactureService.retrieveAllFactures();
		int expected = cp.size();
		Facture F = new Facture(null, 20,1000,dateCreationFacture,dateDerniereModificationFacture, null, null, null, null);
		Facture facture= FactureService.addFacture(F);
		assertEquals(expected + 1, FactureService.retrieveAllFactures().size());		
      }
}
