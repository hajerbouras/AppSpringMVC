package tn.enig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tn.enig.model.Affectation;
import tn.enig.model.Enseignant;
import tn.enig.model.Matiere;

@Repository
public class GestionImp implements IGestion {
	
	@Autowired
	@Qualifier("dataSource")
    private DataSource data;
	private Object getMatById;

	private void setData(DataSource data) {
		this.data = data;
	}

	@Override
	public List<Matiere> getAllMatiere() {
		List<Matiere> liste = null;
		try {
			liste = new ArrayList<Matiere>();
			Connection cxt = data.getConnection();
			PreparedStatement ps = cxt.prepareStatement("select * from Matiere");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Matiere mat = new Matiere();
				mat.setId(rs.getInt("id"));
				mat.setTitre(rs.getString("titre"));
				mat.setNiveau(rs.getString("niveau"));
				mat.setNbheure(rs.getInt("nbheure"));
				liste.add(mat);
			}
			
		} catch(Exception e) {
			
			 e.printStackTrace();
			
		}
		return liste;
	}
	
	
	@Override
	public void addMatiere(Matiere m) {
		
		try {
            Connection con = data.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into matiere (titre,niveau,nbheure) values (?,?,?)");
            ps.setString(1,m.getTitre());
            ps.setString(2, m.getNiveau());
            ps.setInt(3, m.getNbheure());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public List<Enseignant> getAllEnseignant() {
		List<Enseignant> liste = null;
		try {
			liste = new ArrayList<Enseignant>();
			Connection cxt = data.getConnection();
			PreparedStatement ps = cxt.prepareStatement("select * from Enseignant");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Enseignant ens = new Enseignant();
				ens.setId(rs.getInt("id"));
				ens.setNom(rs.getString("nom"));
				ens.setPrenom(rs.getString("prenom"));
				ens.setCharge(rs.getString("charge"));
				liste.add(ens);
			}
			
		} catch(Exception e) {
			
		}
		return liste;
	}

	@Override
	public void addEnseignant(Enseignant e) {
		try {
            Connection con = data.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into enseignant (titre,niveau,nbheure) values (?,?,?)");
            ps.setString(1,e.getNom());
            ps.setString(2, e.getPrenom());
            ps.setString(3, e.getCharge());

            ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}

	@Override
	public List<Affectation> getAllAffectation() {
		List<Affectation> liste = null;
		try {
			liste = new ArrayList<Affectation>();
			Connection cxt = data.getConnection();
			PreparedStatement ps = cxt.prepareStatement("select * from Affectation");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Affectation aff = new Affectation();
				aff.setId(rs.getInt("id"));
				aff.setMatiere(this.getMatierebyID(rs.getInt("matiere")));
				aff.setEnseignant(this.getEnseignantbyID(rs.getInt("enseignant")));
				
				liste.add(aff);
			}
			
		} catch(Exception e) {
			
		}
		return liste;
	}

	@Override
	public void addAffectation(Affectation a) {
		 try {
	            Connection con = data.getConnection();
	            PreparedStatement ps=con.prepareStatement("insert into affectation (id,matiere,enseignant) values (?,?,?)");
	            ps.setInt(1,a.getId());
	            ps.setInt(2, a.getMatiere().getId());
	            ps.setInt(3, a.getEnseignant().getId());

	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
	public Matiere getMatierebyID(int id) {
		Matiere mat = null;
        try {
            Connection con = data.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from matiere where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                mat = new Matiere();
                mat.setId(rs.getInt("id"));
                mat.setTitre(rs.getString("titre"));
                mat.setNiveau(rs.getString("niveau"));
                mat.setNbheure(rs.getInt("nbheure"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mat;
		
	}
	
	public Enseignant getEnseignantbyID(int id) {
		Enseignant ens = null;
        try {
            Connection con = data.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from enseignant where id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ens = new Enseignant();
                ens.setId(rs.getInt("id"));
                ens.setNom(rs.getString("nom"));
                ens.setPrenom(rs.getString("prenom"));
                ens.setCharge(rs.getString("charge"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ens;
		
		
	}
	
	

}
