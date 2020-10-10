package br.uefs.ecomp.delivery;

import br.uefs.ecomp.delivery.model.PedidoTeste;
import br.uefs.ecomp.delivery.model.ItemPedidoTest;
import br.uefs.ecomp.delivery.model.ClienteTeste;
import br.uefs.ecomp.delivery.model.CardapioTeste;
import br.uefs.ecomp.delivery.model.SystemTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.uefs.ecomp.delivery.util.ListTest;
import br.uefs.ecomp.delivery.util.QueueTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        QueueTest.class,
        ListTest.class,
        ItemPedidoTest.class,
        PedidoTeste.class,
        ClienteTeste.class,
		CardapioTeste.class,
        SystemTest.class
})

public class AllTests { }
