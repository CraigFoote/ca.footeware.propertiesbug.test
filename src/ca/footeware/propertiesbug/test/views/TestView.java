/**
 * 
 */
package ca.footeware.propertiesbug.test.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.part.ViewPart;

import ca.footeware.propertiesbug.test.model.Foo;

/**
 *
 */
public class TestView extends ViewPart {
	private StructuredViewer viewer;

	/**
	 * 
	 */
	public TestView() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets
	 * .Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new ListViewer(parent, SWT.BORDER);
		viewer.setContentProvider(new ArrayContentProvider());
		viewer.setLabelProvider(new LabelProvider());
		viewer.setInput(getInput());
		getSite().setSelectionProvider(viewer);
		IPartService partService = (IPartService) getSite().getService(
				IPartService.class);
		partService.addPartListener(new IPartListener2() {
			@Override
			public void partVisible(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("visible");
				}
			}
			
			@Override
			public void partOpened(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("opened");
				}
			}
			
			@Override
			public void partInputChanged(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("inputchanged");
				}
			}
			
			@Override
			public void partHidden(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("hidden");
				}
			}
			
			@Override
			public void partDeactivated(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("deactivated");
				}
			}
			
			@Override
			public void partClosed(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("closed");
				}
			}
			
			@Override
			public void partBroughtToTop(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("brought to top");
				}
			}
			
			@Override
			public void partActivated(IWorkbenchPartReference partRef) {
				if(partRef.getId().equals(TestView.this.getSite().getId())){
					System.err.println("activated");
				}
			}
		});
	}

	private List<Foo> getInput() {
		List<Foo> foos = new ArrayList<Foo>();
		foos.add(new Foo("one"));
		foos.add(new Foo("two"));
		return foos;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		if (viewer != null && viewer.getControl() != null
				&& !viewer.getControl().isDisposed()) {
			viewer.getControl().setFocus();
		}
	}
}
