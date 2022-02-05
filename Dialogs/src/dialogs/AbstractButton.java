package dialogs;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;

public abstract class AbstractButton {
	private String label;
	private Button button;

	public AbstractButton(String label) {
		this.label = label;
	}

	public abstract void doAction();

	public void create(Shell shell, Control control) {
		button = new Button(shell, SWT.PUSH);
		FormData data = new FormData();
		if (control != null) {
			data.left = new FormAttachment(control, 0, SWT.RIGHT);
		}
		getButton().setText(getLabel());
		getButton().setLayoutData(data);
		getButton().addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				doAction();
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {

			}
		});
	}
	
	public String getLabel() {
		return label;
	}

	public Button getButton() {
		return button;
	}

	public void enableByTableSelection(TableItem[] selection) {

	}

}
