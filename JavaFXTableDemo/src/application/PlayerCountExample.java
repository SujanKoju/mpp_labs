package application;


import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PlayerCountExample extends Application {
    
    private Player draggedPlayer = null ;

	@Override
	public void start(Stage primaryStage) {
	    
	    final int numTeams = 10 ;
	    final int numPlayers = 100 ;
	    
		ObservableList<Team> teamList = FXCollections.observableList(createTeams(numTeams));
		
		
		ObservableList<Player> playerList = FXCollections.observableList(createPlayers(numPlayers, teamList), 
		        p -> new Observable[] {p.teamProperty()});
		
		FilteredList<Player> playersByTeam = new FilteredList<>(playerList, p -> false);
		
		TableView<Team> teamTable = new TableView<>();
		TableColumn<Team, Number> playerCountCol = new TableColumn<>("Player Count");
		playerCountCol.setCellValueFactory(cellData -> 
                    Bindings.createLongBinding(() -> 
                        playerList.stream()
                        .filter(player -> player.getTeam().equals(cellData.getValue()) )
                        .collect(Collectors.counting()),
                        playerList));
		
		TableColumn<Team, String> teamNameCol = new TableColumn<>("Name");
		teamNameCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
		
		teamTable.getColumns().add(teamNameCol);
		teamTable.getColumns().add(playerCountCol);
		teamTable.setItems(teamList);
		
		ListView<Player> playerListView = new ListView<>();
		playerListView.setItems(playersByTeam);
		playerListView.setCellFactory(lv -> {
		    ListCell<Player> cell = new ListCell<Player>() {
		        @Override
	            public void updateItem(Player player, boolean empty) {
	                super.updateItem(player, empty);
	                if (empty) {
	                    setText(null);
	                } else {
	                    setText(player.getName() + " ("+player.getTeam()+")");
	                }
	            }
		    };
		    cell.setOnDragDetected(e -> {
		        if (cell.isEmpty()) {
		            return ;
		        }
		        Dragboard db = cell.startDragAndDrop(TransferMode.MOVE);
		        ClipboardContent cc = new ClipboardContent();
		        cc.putString("player");
		        draggedPlayer = cell.getItem() ;
		        db.setContent(cc);
		    });
		    
		    return cell ;
		});
		
		teamTable.getSelectionModel().selectedItemProperty().addListener((obs, oldTeam, newTeam) -> {
		    if (newTeam == null) {
		        playersByTeam.setPredicate(p -> false);
		    } else {
		        playersByTeam.setPredicate(p -> newTeam.equals(p.getTeam()));
		    }
		});
		
		teamTable.setRowFactory(tv -> {
		    TableRow<Team> row = new TableRow<>();
		    row.setOnDragOver(e -> {
		        if (row.isEmpty()) {
		            return ;
		        }
		        Dragboard db = e.getDragboard();
		        if ("player".equals(db.getString()) && draggedPlayer != null) {
		            e.acceptTransferModes(TransferMode.MOVE);
		        }
		    });
		    row.setOnDragDropped(e -> {
		        if (row.isEmpty()) {
		            return ;
		        }
		        Dragboard db = e.getDragboard() ;
		        if ("player".equals(db.getString()) && draggedPlayer != null) {
		            draggedPlayer.setTeam(row.getItem());
		            draggedPlayer = null ;
		            e.setDropCompleted(true);
		        } else {
		            e.setDropCompleted(false);
		        }
		        
		    });
		    
		    return row ;
		});
		
		HBox root = new HBox(10, teamTable, playerListView);
		root.setPadding(new Insets(10));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private List<Team> createTeams(int numTeams) {
	    return IntStream.rangeClosed(1, numTeams)
                .mapToObj(i -> new Team(i, "Team "+i))
                .collect(Collectors.toList());
	}
	
	private List<Player> createPlayers(int numPlayers, List<Team> teamList) {
	    Random rng = new Random();
	    int numTeams = teamList.size() ;
	    return IntStream.rangeClosed(1, numPlayers)
                .mapToObj(i -> new Player(i, "Player "+i, teamList.get(rng.nextInt(numTeams))))
                .collect(Collectors.toList());
	}
	
	public static class Team {
	    
	    private final int id ;
	    private String name ;
        public Team(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public int getId() {
            return id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return getName();
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null) 
                return false ;
            if (! (obj.getClass() == Team.class)) 
                return false ;
            return Objects.equals(name, ((Team)obj).name);
        }
	    
	}
	
	public static class Player {
	    
	    private final int id ;
	    private final StringProperty name = new SimpleStringProperty();
	    private final ObjectProperty<Team> team = new SimpleObjectProperty<>();
	    
	    public Player(int id, String name, Team team) {
	        this.id = id ;
	        setName(name);
	        setTeam(team);
	    }

        public final StringProperty nameProperty() {
            return this.name;
        }

        public final java.lang.String getName() {
            return this.nameProperty().get();
        }

        public final void setName(final java.lang.String name) {
            this.nameProperty().set(name);
        }

        public final ObjectProperty<Team> teamProperty() {
            return this.team;
        }

        public final PlayerCountExample.Team getTeam() {
            return this.teamProperty().get();
        }

        public final void setTeam(final PlayerCountExample.Team team) {
            this.teamProperty().set(team);
        }

        public int getId() {
            return id;
        }
        
        @Override
        public String toString() {
            return getName();
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(name.get(), team.get());
        }
	    
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true ;
	        }
	        if (obj == null) 
	            return false ;
	        if (! (obj.getClass() == Player.class))
	            return false ;
	        
	        Player p = (Player)obj ;
	        return Objects.equals(name.get(), p.name.get()) 
	                && Objects.equals(team.get(), p.team.get());
	    }
	}

	public static void main(String[] args) {
		launch(args);
	}
}
