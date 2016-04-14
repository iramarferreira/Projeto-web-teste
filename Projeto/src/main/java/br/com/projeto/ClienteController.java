package br.com.projeto;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean
@SessionScoped
public class ClienteController {

	private Cliente cliente;
	private ClienteJpaDAO clienteDao;
	
	public Cliente getCliente(){
		return cliente;
	}
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public ClienteJpaDAO getClienteDao(){
		return clienteDao;
	}
	public void setClienteDao(ClienteJpaDAO clienteDao){
		this.clienteDao = clienteDao;
	}
	
	public ClienteController() {
		clienteDao = ClienteJpaDAO.getInstance();
		this.cliente = new Cliente();
		// TODO Auto-generated constructor stub
	}
	
	public String adiciona(){
		this.clienteDao.persist(this.cliente);
		this.cliente = new Cliente();
		return "/principal?faces-redirect=true";
	}

	public List<Cliente> getListar(){
		return clienteDao.findAll();
	}
	
	public String remover(){
		this.clienteDao.removeById(this.cliente.getId());
		this.cliente = new Cliente();
		return "/principal?faces-redirect=true";
	}
	
	public String buscaAltera(){
		
		this.cliente = this.clienteDao.getById(this.cliente.getId());
		if(this.cliente != null){
			return "/alterarCliente?faces-redirect=true";
		}
		else{
			this.cliente = new Cliente();
			return "/principal?faces-redirect=true";
		}
	}
	
	public String getAlterar(){
		try{
			this.clienteDao.getMerge(this.cliente);
			cliente = new Cliente();
		}catch(Exception e){
			this.cliente = new Cliente();
		}
		return "/principal?faces-redirect=true";
	}
}
