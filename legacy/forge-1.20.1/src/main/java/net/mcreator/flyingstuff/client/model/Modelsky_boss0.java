package net.mcreator.flyingstuff.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelsky_boss0<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("flying_stuff", "modelsky_boss_0"), "main");
	public final ModelPart left_leg;
	public final ModelPart left_arm;
	public final ModelPart right_arm;
	public final ModelPart right_leg;
	public final ModelPart torso;
	public final ModelPart head;

	public Modelsky_boss0(ModelPart root) {
		this.left_leg = root.getChild("left_leg");
		this.left_arm = root.getChild("left_arm");
		this.right_arm = root.getChild("right_arm");
		this.right_leg = root.getChild("right_leg");
		this.torso = root.getChild("torso");
		this.head = root.getChild("head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg",
				CubeListBuilder.create().texOffs(67, 75).addBox(2.0F, 21.0F, -8.0F, 9.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(104, 116).addBox(2.0F, 14.0F, -3.0F, 7.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(52, 107)
						.addBox(1.0F, -3.0F, -3.0F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(26, 121).addBox(4.0F, 3.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition left_arm = partdefinition
				.addOrReplaceChild(
						"left_arm", CubeListBuilder.create().texOffs(79, 55).addBox(4.0F, 28.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(68, 91).addBox(5.0F, 20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
								.texOffs(34, 65).addBox(3.0F, 0.0F, -6.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(80, 110).addBox(6.0F, 9.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(8.0F, -30.0F, -6.0F));
		PartDefinition right_arm = partdefinition
				.addOrReplaceChild(
						"right_arm", CubeListBuilder.create().texOffs(36, 88).addBox(-11.0F, 20.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 53).addBox(-12.0F, 1.0F, -6.0F, 11.0F, 11.0F, 12.0F, new CubeDeformation(0.0F))
								.texOffs(110, 44).addBox(-10.0F, 9.0F, -3.0F, 6.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(76, 32).addBox(-12.0F, 28.0F, -5.0F, 10.0F, 8.0F, 10.0F, new CubeDeformation(0.0F)),
						PartPose.offset(-10.0F, -31.0F, -5.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg",
				CubeListBuilder.create().texOffs(0, 76).addBox(-11.0F, 20.0F, -8.0F, 9.0F, 3.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 115).addBox(-9.0F, 13.0F, -3.0F, 7.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).texOffs(120, 61)
						.addBox(-8.0F, 2.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(98, 73).addBox(-9.0F, -4.0F, -3.0F, 8.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 1.0F, 0.0F));
		PartDefinition torso = partdefinition.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(22, 104).addBox(8.0F, -38.0F, -5.0F, 4.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(106, 22).addBox(-12.0F, -38.0F, -5.0F, 4.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(48, 0)
						.addBox(-11.0F, -36.0F, -4.0F, 22.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(100, 4).addBox(-8.0F, -13.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(2, 94)
						.addBox(2.0F, -13.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(50, 17).addBox(-10.0F, -18.0F, -5.0F, 20.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-9.0F, -32.0F, -6.0F, 18.0F, 15.0F, 12.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 9.0F, 0.0F, 0.1309F, 0.0F, 0.0F));
		PartDefinition head = partdefinition
				.addOrReplaceChild(
						"head", CubeListBuilder.create().texOffs(0, 27).addBox(-8.0F, -14.0F, -7.0F, 16.0F, 15.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 136).addBox(-9.0F, -15.0F, -8.0F, 18.0F, 16.0F, 12.0F, new CubeDeformation(0.0F))
								.texOffs(39, 39).addBox(-6.0F, -11.0F, -5.0F, 12.0F, 13.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(100, 91).addBox(-3.0F, -11.0F, -3.25F, 5.0F, 19.0F, 6.0F, new CubeDeformation(0.0F)),
						PartPose.offset(0.0F, -32.0F, -5.0F));
		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		torso.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.head.xRot = headPitch / (180F / (float) Math.PI);
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
