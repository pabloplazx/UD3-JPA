package main;

import java.util.Arrays;
import java.util.List;

import com.dam2.model.Departamento;
import com.dam2.model.Empleado;
import com.dam2.service.EmpresaService;

public class Main2 {

	public static void main(String[] args) {
		
		EmpresaService es = new EmpresaService();
		
		//Departamento d = es.recuperarDepartamentoId(1).get();
		//System.out.println(d.getNombre());
		
		//ESTO ME DA LAZYINITIALIZATION EXCEPTION:
		//d.getEmpleados().stream().forEach(System.out::println);
		
		//d = es.recuperarDepartamentoIdConEmpleados(1).get();
		//d.getEmpleados().stream().forEach(System.out::println);
		
		//List<Empleado> emps = es.recuperarEmpleadosDepartamento(1);
		//emps.stream().forEach(System.out::println);
		
		//String[] empleados = {"Nube","Montaña","Colina"};
		
		//es.crearDepartamentoConEmpleados("COCHES",Arrays.asList(empleados) );
		
		es.trasladarEmpleado(1,1);

	}

}
