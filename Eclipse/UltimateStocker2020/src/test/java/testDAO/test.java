package testDAO;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestChefMagasinDAO.class,
	TestChefRayonDAO.class, 
	TestProduitDAO.class, 
	TestRayonDAO.class, 
})
public class test {
}
