package testRunners;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import controler.ChefMagasinDAO;
import controler.RayonDAO;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import model.ChefMagasin;
import model.Rayon;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true)
public class RunCucumberTest {
	@AfterClass
	public static void tearDown() {
		ChefMagasin ChefMagasin1 = ChefMagasinDAO.rechercheChefMagasinById(1);
		ChefMagasinDAO.supprimerChefMagasin(ChefMagasin1);
		ArrayList<Rayon> ListRayon = RayonDAO.returnAllRayon();
		for (int i=0;i<ListRayon.size();i++)
		{
			RayonDAO.supprimerRayon(ListRayon.get(0));
		}
	}
}
