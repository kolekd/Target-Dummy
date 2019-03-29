package com.dummy.ui;

import com.dummy.model.Environment;
import com.dummy.model.attack.Attack;
import com.dummy.model.attack.identifier.AbilityIdentifier;
import com.dummy.model.buff.Buff;
import com.dummy.model.factory.ClassFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class AttackPanel implements ActionListener {

    JFrame mainFrame;
    JFrame classFrame;
    List<String> classNameList;
    List<JButton> AttackButtonList;
    List<JButton> BuffButtonList;
    List<JButton> classButtonList;
    JButton jChangeClass;
    JLabel mainHpLabel;
    JLabel mainHeroClass;
    Environment environment;
//    SpringLayout springLayout;

    public AttackPanel(){
        this.environment = new Environment();
//        this.springLayout = new SpringLayout();
        this.AttackButtonList = new ArrayList<>();
        this.BuffButtonList = new ArrayList<>();
        this.classButtonList = new ArrayList<>();
        this.classNameList = ClassFactory.createAllClasses();

        mainGUI();
        classGUI();
//        setLayout(springLayout);
    }

    private void classGUI(){
        classFrame = new JFrame("Pick a class");
        classFrame.setSize(400, 400);
        classFrame.setLayout(new GridLayout(3, 3));

        for (String className : classNameList){
            classButtonList.add(new JButton(className));
        }

        for (JButton classButton : classButtonList){
            classFrame.add(classButton);
            classButton.addActionListener(this);
        }

        classFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        classFrame.setVisible(false);
    }

    private void mainGUI(){
        mainFrame = new JFrame("Dummy");
        mainFrame.setSize(400,650);
        mainFrame.setLayout(new GridLayout(15, 1));

        mainHeroClass = new JLabel(environment.hero.heroClass);
        jChangeClass = new JButton("Change Class");
        mainHpLabel = new JLabel("HP: " + environment.target.hp);

//        setLayout(new FlowLayout());

        mainFrame.add(jChangeClass);
        jChangeClass.addActionListener(this);
        mainFrame.add(mainHeroClass);
        mainFrame.add(mainHpLabel);

        updateButtons();

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        mainFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (String string : classNameList){
            if(e.getActionCommand().equals(string)){
                classFrame.setVisible(false);
                environment.setHeroButton(string);
                mainHeroClass.setText(string);
                updateButtons();
                mainFrame.setVisible(true);
            }
        }

        if (e.getActionCommand().equals(jChangeClass.getText())){
            mainFrame.setVisible(false);
            classFrame.setVisible(true);
        } else if (AbilityIdentifier.isAttack(e.getActionCommand())) {
            environment.heroAttackTarget(e.getActionCommand());
            System.out.println("\"" + e.getActionCommand() + "\"");
            mainHpLabel.setText("HP: " + String.valueOf(environment.target.hp));
            updateButtons();
        } else if (AbilityIdentifier.isBuff(e.getActionCommand())){
            AbilityIdentifier.identifyBuff(e.getActionCommand(), environment.hero);
            System.out.println("\"" + e.getActionCommand() + "\"");
            updateButtons();
        }
    }

    public void updateButtons(){
        for (JButton jButton : AttackButtonList){
            mainFrame.remove(jButton);
        }
        for (JButton jButton : BuffButtonList){
            mainFrame.remove(jButton);
        }

        AttackButtonList.clear();
        BuffButtonList.clear();

        updateAttacks();
        updateBuffs();

        for (JButton jButton : AttackButtonList){
            mainFrame.add(jButton);
            jButton.addActionListener(this);
        }

        for (JButton jButton : BuffButtonList){
            mainFrame.add(jButton);
            jButton.addActionListener(this);
// TODO:   Buff, Seal, Judegement, Paladin
        }
    }

    public void updateAttacks(){
        for (Attack attack : environment.hero.getAttackSet()){
            JButton currentAttackButton = new JButton(attack.name);
            AttackButtonList.add(currentAttackButton);
            if(!attack.isAvailable){
                currentAttackButton.setEnabled(false);
            } else {
                currentAttackButton.setEnabled(true);
            }
        }
    }

    public void updateBuffs(){
        for(Buff buff : environment.hero.getBuffSet()){
            JButton currentBuffButton = new JButton(buff.name);
            BuffButtonList.add(currentBuffButton);
        }
    }
}
