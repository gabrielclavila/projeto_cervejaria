package br.com.springboot.curso_jdev_treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.curso_jdev_treinamento.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	/*Como não existe no JpaRepository um método específico para consultar por Nome é necessário criarmos a assinatura deste novo método nesta Inteface
	 *e implementar a consulta SQL (HQL), que referencia Classes e atributos e não diretamente as tabelas e colunas do BD
	 *Na consulta o sinal ? significa que vai ser passado o valor de um parâmetro e o número 1 diz qual é este parâmetro e o TRIM é uma funçaõ SQL
	 *para retirar espaços em branco e o UPPER coloca todo o nome em Maiúsculo*/	
	@Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%") 
	List<Usuario> buscaPorNome(String name);

}
