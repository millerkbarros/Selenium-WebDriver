import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastroDSL.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamentoDSL.class
})
public class SuiteTeste {

}
