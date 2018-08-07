package br.org.cpb.cadgeral.util.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseListenerImpl implements PhaseListener {

	private static final long serialVersionUID = 1L;

	// private Logger logger = Logger.getLogger(PhaseListenerImpl.class.getName());

	@Override
	public void afterPhase(PhaseEvent pe) {
		// logger.info("After Phase: " + pe.getPhaseId().toString() + " invoked.");
	}

	@Override
	public void beforePhase(PhaseEvent pe) {
		// logger.info("Before Phase: " + pe.getPhaseId().toString() + " invoked.");
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}