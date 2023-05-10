package controller;

import model.Model;
import view.View;

public class Controller {
	protected View view;
	protected Model model;

	public Controller(View view, Model model) {
		super();
		this.view = view;
		this.model = model;
	}

}
