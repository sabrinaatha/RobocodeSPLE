package jab.movement;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import jab.module.Module;
import jab.module.Movement;

public class KeyboardMovement extends Movement {

	/**
	 * Credits Interactive - a sample robot by Flemming N. Larsen.
	 */
	public KeyboardMovement(Module bot) {
		super(bot);
	}

	// Move direction: 1 = move forward, 0 = stand still, -1 = move backward
	int moveDirection;

	// Turn direction: 1 = turn right, 0 = no turning, -1 = turn left
	double turnDirection;

	// Amount of pixels/units to move
	double moveAmount;
	
	boolean isSprinting = false; // Mode Sprint

	// Tambahan fitur baru:
	boolean autoMove = false; // Mode Auto-Move

	public void move() {
		// Sets the robot to move forward, backward or stop moving depending
		// on the move direction and amount of pixels to move
		
		// Sprint Mode: Jika tombol SHIFT ditekan, kecepatan x2
		double speedMultiplier = isSprinting ? 2.0 : 1.0;
		bot.setAhead(speedMultiplier * moveAmount * moveDirection);

		// Jika Auto-Move aktif, terus maju
		if (autoMove) {
			moveDirection = 1;
			moveAmount = Double.POSITIVE_INFINITY;
		}

		// Decrement the amount of pixels to move until we reach 0 pixels
		// This way the robot will automatically stop if the mouse wheel
		// has stopped it's rotation
		moveAmount = Math.max(0, moveAmount - 1);

		// Sets the robot to turn right or turn left (at maximum speed) or
		// stop turning depending on the turn direction
		bot.setTurnRight(45 * turnDirection); // degrees
	}

	public void listenInput(InputEvent e) {
		if (e instanceof KeyEvent) {
			if (((KeyEvent) e).getID() == KeyEvent.KEY_PRESSED)
				switch (((KeyEvent) e).getKeyCode()) {
				case KeyEvent.VK_UP:
					moveDirection = 1;
					moveAmount = Double.POSITIVE_INFINITY;
					break;

				case KeyEvent.VK_DOWN:
					moveDirection = -1;
					moveAmount = Double.POSITIVE_INFINITY;
					break;

				case KeyEvent.VK_RIGHT:
					turnDirection = 1;
					break;

				case KeyEvent.VK_LEFT:
					turnDirection = -1;
					break;
					
				// Tambahan fitur baru:
				case KeyEvent.VK_SHIFT: // Sprint Mode
					isSprinting = true;
					break;

				case KeyEvent.VK_SPACE: // Berhenti Instan
					moveDirection = 0;
					moveAmount = 0;
					turnDirection = 0;
					break;

				case KeyEvent.VK_A: // Rotasi Halus ke Kiri
					turnDirection = -0.5;
					break;

				case KeyEvent.VK_D: // Rotasi Halus ke Kanan
					turnDirection = 0.5;
					break;

				case KeyEvent.VK_W: // Auto-Move (Maju Terus)
					autoMove = true;
					moveDirection = 1;
					moveAmount = Double.POSITIVE_INFINITY;
					break;

				case KeyEvent.VK_S: // Berhenti Auto-Move
					autoMove = false;
					moveDirection = 0;
					break;

				case KeyEvent.VK_R: // U-Turn (Putar Balik 180°)
					bot.setTurnRight(180);
					break;
				}
			else if (((KeyEvent) e).getID() == KeyEvent.KEY_RELEASED)
				switch (((KeyEvent) e).getKeyCode()) {
				case KeyEvent.VK_UP:
				case KeyEvent.VK_DOWN:
					// Arrow up and down keys: move direction = stand still
					moveDirection = 0;
					break;

				case KeyEvent.VK_RIGHT:
				case KeyEvent.VK_LEFT:
					// Arrow right and left keys: turn direction = stop turning
					turnDirection = 0;
					break;
					
				// Tambahan fitur baru:
				case KeyEvent.VK_SHIFT: // Lepas Shift, sprint berhenti
					isSprinting = false;
					break;

				case KeyEvent.VK_A:
				case KeyEvent.VK_D:
					turnDirection = 0;
					break;
				}

		}
	}

}
