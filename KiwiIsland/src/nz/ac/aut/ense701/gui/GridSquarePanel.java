package nz.ac.aut.ense701.gui;

import java.awt.Color;
import java.util.Set;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nz.ac.aut.ense701.gameModel.Game;
import nz.ac.aut.ense701.gameModel.Occupant;
import nz.ac.aut.ense701.gameModel.Position;
import nz.ac.aut.ense701.gameModel.Terrain;

/*
 * Panel for representing a single GridSquare of the island on the GUI.
 * 
 * @author AS
 * @version 1.0 - created
 */

public class GridSquarePanel extends javax.swing.JPanel 
{
    /** 
     * Creates new GridSquarePanel.
     * @param game the game to represent
     * @param row the row to represent
     * @param column the column to represent
     */
    public GridSquarePanel(Game game, int row, int column)
    {
        this.game   = game;
        this.row    = row;
        this.column = column;
        initComponents();
    }

    /**
     * Updates the representation of the grid square panel.
     */
    public void update()
    {
        // get the GridSquare object from the world
        Terrain terrain   = game.getTerrain(row, column);
        boolean squareVisible = game.isVisible(row, column);
        boolean squareExplored = game.isExplored(row, column);
        
        Color      color;
        
        switch ( terrain )
        {
            case SAND     : color = Color.YELLOW; break;
            case FOREST   : color = Color.GREEN;  break;
            case WETLAND : color = Color.BLUE; break;
            case SCRUB : color = Color.DARK_GRAY;   break;
            case WATER    : color = Color.CYAN;   break;
            default  : color = Color.LIGHT_GRAY; break;
        }
        
        /*Occupant occupant = game.getIsland().getOccupants(this.game.getIsland().getOccupants(Position.NOT_ON_ISLAND))
        
        if (game.getOccupantName(row, column).contains("Kiwi")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/apple2_1.png")));  // URL
        }
        /*if (occupants == null){
        } else {
            //System.out.println(occupants[0].toString());
        }*/
        if ( squareExplored || squareVisible )
        {
            // Set the text of the JLabel according to the occupant
            lblText.setText(game.getOccupantStringRepresentation(row,column));
            if (game.getOccupantName(row, column).contains("Apple")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/apple2_1.png")));  // URL
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Burger")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/burger_1.png")));  // URL
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Juice")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/juice_1.png")));  // URL 
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Crab")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/crab.png")));  // URL 
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Kiwi")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/kiwi_2.png")));  // URL 
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Kiore")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/kiore_rat_1.png")));  // URL
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Possum")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/possum_1.png")));  // URL
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Screwdriver")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/screwdriver_1.png")));  // URL 
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Stoat")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/stoat_1.png")));  // URL 
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Rat")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/rat_1.png")));  // URL 
                lblText.setText("");  // URL 
            }
            else if (game.getOccupantName(row, column).contains("Cat")){
                lblText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/nz/ac/aut/ense701/images/cat_1.png")));  // URL 
                lblText.setText("");  // URL 
            }

            // Set the colour. 
            if ( squareVisible && !squareExplored ) 
            {
                // When explored the colour is brighter
                color = new Color(Math.min(255, color.getRed()   + 128), 
                                  Math.min(255, color.getGreen() + 128), 
                                  Math.min(255, color.getBlue()  + 128));
            }
            lblText.setBackground(color);
            // set border colour according to 
            // whether the player is in the grid square or not
            setBorder(game.hasPlayer(row,column) ? activeBorder : normalBorder);
        }
        else
        {
            lblText.setText("");
            lblText.setIcon(null);
            lblText.setBackground(Color.LIGHT_GRAY);
            setBorder(normalBorder);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setLayout(new java.awt.BorderLayout());

        lblText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblText.setText("content");
        lblText.setOpaque(true);
        add(lblText, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
    
    private Game game;
    private int row, column;
    
    private static final Border normalBorder = new LineBorder(Color.BLACK, 0);
    private static final Border activeBorder = new LineBorder(Color.RED, 3);
}
