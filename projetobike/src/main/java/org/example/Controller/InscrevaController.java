package org.example.Controller;


import lombok.RequiredArgsConstructor;
import org.example.Model.SeguroIncrevase;
import org.example.Service.SeguroInscrevaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/inscrevase") // falta colocar o caminho do banco
public class SeguroInscrevaController {

    private static final Logger logger = LogManager.getLogger(SeguroInscrevaController.class);
    private final SeguroInscrevaseService seguroInscrevaseService;

    @PostMapping
    public ResponseEntity<String> create (@RequestBody SeguroIncrevase seguroIncrevase){
        logger.info("Requisição para criar usuário recebida");

        try {
            SeguroIncrevase user = seguroInscrevaseService.salvar(seguroIncrevase);
            logger.info("Usuário craido com secesso: {}", user);
            return ResponseEntity.status(HttpStatus.CREATED).body(user.toString());
        }catch (Exception e ) {
            logger.error("erro de se cadastrar:", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro de se cadsatrar: " + e.getMessage());
          }
    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        logger.info("Requisição para buscar usuário por Id recebida: {}", id);
        try {
            SeguroIncrevase user = seguroInscrevaseService.buscarPorId(id);
            if (user == null) {
                logger.warn("Usuário não encontrado: {}", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
            }
            logger.info("Usuário encontrado: {}", user);
            return ResponseEntity.ok(user);
        } catch (Exception e){
            logger.error("Erro ao buscar usuário por Id:", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao buscar usuário: " + e.getMessage());
        }
    }
    @PostMapping ("/login")
    public ResponseEntity<String> login(@RequestBody SeguroIncrevase seguroIncrevase){
        logger.info("Requisição para login recebida");

        try {
            // Verificar se o email e a senha foram fornecidos
            if (seguroIncrevase.getEmail() == null || seguroIncrevase.getSenha() == null) {
                logger.warn("Email ou senha não foram fornecidos");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email e senha são obrigatórios");

            }
            // Buscar usuários pelo email
            SeguroIncrevase user = seguroInscrevaseService.buscarPorEmail(seguroIncrevase.getEmail());

            // Verificar se o usuário existe
            if (user == null) {
                logger.warn("Usuário não encontrado para o email fornecido: {}", seguroIncrevase.getEmail());
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");

            }
            // Verificar se a senha está correta
            if (!seguroIncrevase.getSenha().equals(user.getSenha())) {
                logger.warn("Senha incorreta para o usuário com o email: {}", seguroIncrevase.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha incorreta");

            }
            logger.info("Login bem-sucedido para o usuário: {}", user.getEmail());
            return ResponseEntity.ok(user);
        }catch ( Exception e){
            logger.error("Erro ao realizar o login:", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar o login" + e.getMessage());

        }
    }
}
