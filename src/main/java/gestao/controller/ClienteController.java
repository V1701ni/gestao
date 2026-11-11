
package gestao.controller;

import gestao.model.Cliente;
import gestao.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // CREATE - Cadastrar cliente
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    // READ - Listar todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    // READ - Buscar cliente por ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // UPDATE - Atualizar cliente
    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        Cliente clienteExistente = clienteService.buscarPorId(id);

        clienteExistente.setNome(cliente.getNome());
        clienteExistente.setEmail(cliente.getEmail());
        clienteExistente.setTelefone(cliente.getTelefone());

        return clienteService.salvar(clienteExistente);
    }

    // DELETE - Excluir cliente
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        clienteService.excluir(id);
    }
}
