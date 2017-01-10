package fr.pizzeria.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.model.Performance;

//@Repository
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
	public List<Performance> findAllPerformance(){
		String sql = "SELECT * FROM performance";

		return this.jdbcTemplate.query(sql, (ResultSet rs, int row) -> {

			Performance p = new Performance();
			p.setId(rs.getInt("id"));
			//p.setDate(rs.getString("date"));
			p.setMilliSecondes(rs.getInt("milliSecondes"));
			p.setService("service");

			return p;
		});
	}
	
	@Override
	public void savePizza(Pizza p) throws PizzaException {
		String sql = "INSERT INTO pizza (code,nom,prix,categorie) VALUES(?,?,?,?)";
		this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(), p.getCategorie().name());

	}

	@Override
	public void updatePizza(int indice, Pizza pizza) throws PizzaException {
		String sql = "UPDATE pizza SET code= ?, nom=?, prix=?, categorie=? WHERE id=?";
		this.jdbcTemplate.update(sql, pizza.getCode(), pizza.getNom(), pizza.getPrix(), pizza.getCategorie().name(),
				indice);

	}

	@Override
	public void deletePizza(String codePizza) throws PizzaException {
		String sql = "DELETE FROM pizza WHERE code=?";
		this.jdbcTemplate.update(sql, codePizza);
	}

	@Override
	public void savePerformance(Performance p) throws PizzaException {
		String sql = "INSERT INTO performance (date, milliSecondes, service) VALUES(?,?,?)";
		this.jdbcTemplate.update(sql, p.getDate(), p.getMilliSecondes(), p.getService());
	}

}
