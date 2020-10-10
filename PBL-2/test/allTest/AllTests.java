package allTest;

import model.AgendamentoTeste;
import model.ConsultaTeste;
import model.ExameTeste;
import model.LoteTeste;
import model.PacienteTeste;
import model.ProcedimentoTeste;
import model.SistemaTeste;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import util.LinkedTest;
import util.FilaPrioridadeTeste;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LinkedTest.class,
    FilaPrioridadeTeste.class, 
    AgendamentoTeste.class,
    ConsultaTeste.class,
    ExameTeste.class,
    LoteTeste.class,
    PacienteTeste.class,
    ProcedimentoTeste.class,
    SistemaTeste.class
})

public class AllTests {
}
