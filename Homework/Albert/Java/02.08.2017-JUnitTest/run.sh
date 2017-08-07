#!/bin/bash

javac Soldier.java Weapon.java Bullet.java
javac -cp .:junit/junit-4.12.jar BulletTest.java WeaponTest.java SoldierTest.java
java -cp .:junit/junit-4.12.jar:junit/hamcrest-core-1.3.jar org.junit.runner.JUnitCore BulletTest WeaponTest SoldierTest

rm -r *.class
