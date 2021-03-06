package com.gmail.berndivader.mmcustomskills26;

import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import io.lumine.xikage.mythicmobs.adapters.AbstractEntity;
import io.lumine.xikage.mythicmobs.adapters.AbstractLocation;
import io.lumine.xikage.mythicmobs.io.MythicLineConfig;
import io.lumine.xikage.mythicmobs.skills.ITargetedEntitySkill;
import io.lumine.xikage.mythicmobs.skills.SkillMechanic;
import io.lumine.xikage.mythicmobs.skills.SkillMetadata;

public class mmStunSkill extends SkillMechanic implements ITargetedEntitySkill {

	public static String str="mmStunned";
	private Integer duration;
	private Boolean f,g;

	public mmStunSkill(String skill, MythicLineConfig mlc) {
		super(skill, mlc);
		this.duration = mlc.getInteger(new String[] { "duration", "d" }, 120);
		this.f = mlc.getBoolean(new String[] { "facing", "face", "f" }, false);
		this.g=mlc.getBoolean(new String[] {"gravity","g"},false);
		this.ASYNC_SAFE = false;
	}

	@Override
	public boolean castAtEntity(SkillMetadata data, AbstractEntity target) {
		final AbstractEntity t = target;
		final AbstractLocation l = target.getLocation().clone();
		final int dur = this.duration;
		final boolean facing=this.f,gravity=this.g;
		target.getBukkitEntity().setMetadata(str, new FixedMetadataValue(Main.getPlugin(), true));
		new BukkitRunnable() {
			long count = 0;
			float yaw=l.getYaw(),pitch=l.getPitch();
			double x=l.getX(),y=l.getY(),z=l.getZ();
			@Override
			public void run() {
				if (t==null
						||t.isDead()
						||count>dur) {
					t.getBukkitEntity().removeMetadata(str, Main.getPlugin());
					this.cancel();
				} else {
					if (facing) {
						yaw=t.getLocation().getYaw();
						pitch=t.getLocation().getPitch();
					}
					if (gravity) y=t.getLocation().getY();
					Main.getPlugin().getVolatileHandler().forceSetPositionRotation(target.getBukkitEntity(),x,y,z,yaw,pitch,facing,gravity);
				}
				count++;
			}
		}.runTaskTimer(Main.getPlugin(), 1L,1L);
		return true;
	}

}
