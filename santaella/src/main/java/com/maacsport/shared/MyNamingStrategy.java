package com.maacsport.shared;


import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;


public class MyNamingStrategy extends org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl {
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return new Identifier("" + name.getText(), name.isQuoted()); // aqui podemos anadir qualquier extendions que queramos colocar en el nombre de nuestras tablas
	}
}
