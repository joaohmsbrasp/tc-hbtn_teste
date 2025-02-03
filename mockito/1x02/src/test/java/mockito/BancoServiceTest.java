package mockito;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BancoServiceTest {

    @Test
    public void testConsultarSaldo() {
        // Criando mock do repositório
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);

        // Criando conta simulada
        Conta contaMock = new Conta("123", 100.0);

        // Definindo comportamento do mock
        when(contaRepositoryMock.buscarConta("123")).thenReturn(contaMock);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepositoryMock);

        // Testando consulta de saldo
        double saldo = bancoService.consultarSaldo("123");

        // Verificando se o saldo está correto
        assertEquals(100.0, saldo);

        // Verificando se o método buscarConta foi chamado
        verify(contaRepositoryMock).buscarConta("123");
    }

    @Test
    public void testDepositar() {
        // Criando mock do repositório
        ContaRepository contaRepositoryMock = mock(ContaRepository.class);

        // Criando conta simulada
        Conta contaMock = new Conta("123", 100.0);

        // Definindo comportamento do mock
        when(contaRepositoryMock.buscarConta("123")).thenReturn(contaMock);

        // Criando serviço com o mock
        BancoService bancoService = new BancoService(contaRepositoryMock);

        // Executando depósito
        bancoService.depositar("123", 50.0);

        // Verificando se o saldo foi atualizado
        assertEquals(150.0, contaMock.getSaldo());

        // Verificando se os métodos foram chamados corretamente
        verify(contaRepositoryMock).buscarConta("123");
        verify(contaRepositoryMock).salvar(contaMock);
    }
}
