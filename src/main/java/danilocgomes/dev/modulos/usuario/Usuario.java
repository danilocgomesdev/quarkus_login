package danilocgomes.dev.modulos.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Usuario  {

    @Id
    public long id;
    public String nome;
    public String email;
    public String senha;

    public Usuario() {
    }
}
