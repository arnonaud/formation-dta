package fr.pizzeria.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoJdbcSpring implements PizzaDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	
	public PizzaDaoJdbcSpring(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

			
	@Override
	public List<Pizza> findAll() {

		String sql = "SELECT * FROM pizza";

		
		
		return this.jdbcTemplate.query(sql, (ResultSet rs, int row) -> {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCode(rs.getString("code"));
			p.setNom(rs.getString("nom"));
			p.setPrix(rs.getDouble("prix"));
			p.setCategorie(CategoriePizza.valueOf(rs.getString("categorie")));

			return p;
		});

			

	}

	@Override
	public void savePizza(Pizza p) throws PizzaException {
		String sql = "INSERT INTO pizza (code,nom,prix,categorie) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, p.getCode(), p.getNom(),p.getPrix(),p.getCategorie().name());

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {
		String sql = "UPDATE pizza SET code= ?, nom=?, prix=?, categorie=? WHERE id=?";
		this.jdbcTemplate.update(sql,pizza.getCode(),pizza.getNom(),pizza.getPrix(),pizza.getCategorie().name(),indice);

	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		String sql = "DELETE FROM pizza WHERE code=?";
		this.jdbcTemplate.update(sql,codePizza);
	}

}
