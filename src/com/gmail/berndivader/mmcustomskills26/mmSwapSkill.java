package com.gmail.berndivader.mmcustomskills26;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;

public class mmSwapSkill extends SkillMechanic implements ITargetedEntitySkill {

	protected Boolean keepTargetYaw;
	protected Boolean keepCasterYaw;

	public mmSwapSkill(String skill, MythicLineConfig mlc) {
		super(skill, mlc);
		this.keepTargetYaw = mlc.getBoolean(new String[] { "keeptargetyaw", "kty" }, false);
		this.keepCasterYaw = mlc.getBoolean(new String[] { "keepcasteryaw", "kcy" }, false);
		this.ASYNC_SAFE = false;
	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {

		AbstractLocation tl = target.getLocation().clone();
		AbstractLocation cl = data.getCaster().getLocation().clone();
		if (this.keepTargetYaw)
			cl.setYaw(target.getLocation().getYaw());
		if (this.keepCasterYaw)
			tl.setYaw(data.getCaster().getLocation().getYaw());

		target.teleport(cl);
		data.getCaster().getEntity().teleport(tl);
		return true;
	}

}
